package com.umc.gwnu.member.infrastructure;

import com.umc.gwnu.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
