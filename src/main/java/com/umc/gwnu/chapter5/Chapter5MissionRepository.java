package com.umc.gwnu.chapter5;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface Chapter5MissionRepository {

    // 리뷰 작성 쿼리
    @Query("insert into Review(memberId, rating, content) values (:memberId, :rating, :content)")
    void saveReview(@Param("memberId")Long memberId, @Param("rating") int rating, @Param("content") String content);

    // 마이페이지 조회 쿼리
    @Query("select m from Member m where m.id = :memberId")
    Member findMemberById(@Param("memberId")Long memberId);

    // 진행 중, 진행 완료 미션 조회 쿼리
    @Query("select m from Mission m where m.memberId = :memberId")
    Page<Mission> findMissionsByMemberId(@Param("memberId")Long memberId, Pageable pageable);

    // 홈 화면 쿼리
    @Query("""
            select new HomeResponse (m.id, s.name, s.category, m.title, m.date, m.status, m.point)
                            from Mission m
                            join m.store s
                            where m.memberId = :memberId
                            order by m.date desc
            """)
    List<HomeResponse> findHomeByMemberId(@Param("memberId")Long memberId);
}
