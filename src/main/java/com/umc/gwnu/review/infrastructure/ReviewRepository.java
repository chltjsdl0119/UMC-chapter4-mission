package com.umc.gwnu.review.infrastructure;

import com.umc.gwnu.review.domain.Review;
import com.umc.gwnu.review.domain.repository.ReviewRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {

}
