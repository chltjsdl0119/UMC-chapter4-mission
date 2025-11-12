package com.umc.gwnu.review.application.dto;

public record CreateReviewRequest(
        String content,
        float rating
) {
}
