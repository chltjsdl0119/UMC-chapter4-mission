package com.umc.gwnu.review.application;

import com.umc.gwnu.global.apipayload.code.GeneralErrorCode;
import com.umc.gwnu.global.apipayload.exception.GeneralException;
import com.umc.gwnu.member.infrastructure.MemberRepository;
import com.umc.gwnu.review.application.dto.CreateReviewRequest;
import com.umc.gwnu.review.application.dto.ReviewResponseDto;
import com.umc.gwnu.review.application.dto.ReviewSearchCondition;
import com.umc.gwnu.review.domain.Review;
import com.umc.gwnu.review.infrastructure.ReviewRepository;
import com.umc.gwnu.store.infrastructure.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public List<ReviewResponseDto> getReviews(ReviewSearchCondition condition) {
        List<Review> reviews = reviewRepository.searchReviews(condition);
        return reviews.stream()
                .map(ReviewResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    public Long registerReview(Long memberId, Long storeId, CreateReviewRequest request) {
        var member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        var store = storeRepository.findById(storeId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        Review review = Review.builder()
                .member(member)
                .store(store)
                .content(request.content())
                .rating(request.rating())
                .build();

        return reviewRepository.save(review).getId();
    }
}
