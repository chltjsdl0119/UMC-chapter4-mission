package com.umc.gwnu.review.application.dto;

public record ReviewResponseDto(
        Long id,
        String storeName,
        String content,
        double rating
) {

    public static ReviewResponseDto fromEntity(com.umc.gwnu.review.domain.Review review) {
        return new ReviewResponseDto(
                review.getId(),
                review.getStore().getName(),
                review.getContent(),
                review.getRating()
        );
    }
}
