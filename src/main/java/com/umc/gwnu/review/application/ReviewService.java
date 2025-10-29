package com.umc.gwnu.review.application;

import com.umc.gwnu.review.application.dto.ReviewResponseDto;
import com.umc.gwnu.review.application.dto.ReviewSearchCondition;
import com.umc.gwnu.review.domain.Review;
import com.umc.gwnu.review.infrastructure.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public List<ReviewResponseDto> getReviews(ReviewSearchCondition condition) {
        List<Review> reviews = reviewRepository.searchReviews(condition);
        return reviews.stream()
                .map(ReviewResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}
