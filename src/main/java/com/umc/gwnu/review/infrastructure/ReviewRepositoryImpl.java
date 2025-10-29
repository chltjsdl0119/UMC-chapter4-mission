package com.umc.gwnu.review.infrastructure;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.umc.gwnu.review.application.dto.ReviewSearchCondition;
import com.umc.gwnu.review.domain.Review;
import com.umc.gwnu.review.domain.repository.ReviewRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.umc.gwnu.review.domain.QReview.review;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Review> searchReviews(ReviewSearchCondition condition) {
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(review.member.id.eq(condition.memberId()));

        if (StringUtils.hasText(condition.storeName())) {
            builder.and(review.store.name.eq(condition.storeName()));
        }

        if (condition.ratingFloor() != null) {
            builder.and(review.rating.goe(condition.ratingFloor())
                    .and(review.rating.lt(condition.ratingFloor() + 1)));
        }

        return jpaQueryFactory
                .selectFrom(review)
                .where(builder)
                .orderBy(review.rating.desc())
                .fetch();
    }
}
