package com.umc.gwnu.review.domain.repository;

import com.umc.gwnu.review.application.dto.ReviewSearchCondition;
import com.umc.gwnu.review.domain.Review;

import java.util.List;

public interface ReviewRepositoryCustom {

    List<Review> searchReviews(ReviewSearchCondition condition);
}
