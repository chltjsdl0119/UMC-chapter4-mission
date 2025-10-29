package com.umc.gwnu.review.application.dto;

public record ReviewSearchCondition(
        
        Long memberId,
        String storeName,
        Integer ratingFloor
) {
}
