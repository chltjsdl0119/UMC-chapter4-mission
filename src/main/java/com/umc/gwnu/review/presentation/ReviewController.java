package com.umc.gwnu.review.presentation;

import com.umc.gwnu.global.apipayload.CommonResponse;
import com.umc.gwnu.review.application.ReviewService;
import com.umc.gwnu.review.application.dto.CreateReviewRequest;
import com.umc.gwnu.review.application.dto.ReviewResponseDto;
import com.umc.gwnu.review.application.dto.ReviewSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<CommonResponse<List<ReviewResponseDto>>> getReviews(
            @RequestParam Long memberId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer ratingFloor
    ) {
        ReviewSearchCondition condition = new ReviewSearchCondition(memberId, storeName, ratingFloor);

        List<ReviewResponseDto> reviews = reviewService.getReviews(condition);
        CommonResponse<List<ReviewResponseDto>> response = CommonResponse.onSuccess(reviews);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CommonResponse<Long>> registerReview(
            @RequestParam Long memberId,
            @RequestParam Long storeId,
            CreateReviewRequest request) {
        Long reviewId = reviewService.registerReview(memberId, storeId, request);
        CommonResponse<Long> response = CommonResponse.onSuccess(reviewId);
        return ResponseEntity.ok(response);
    }
}
