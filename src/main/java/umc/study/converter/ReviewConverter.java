package umc.study.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewAddRequest;
import umc.study.web.dto.UserResponseDto;

@Component
public class ReviewConverter {

    public Review toEntity(Long userId, ReviewAddRequest request, Store store) {
        return Review.builder()
                .body(request.getComment()) // 리뷰 내용
                .score(request.getStar().floatValue()) // 평점
                .store(store) // 연관된 Store
                .build();
    }

    public UserResponseDto.ReviewDto toJoinResultDTO(Review review) {
        return UserResponseDto.ReviewDto.builder()
                .userId(review.getId())
                .comment(review.getBody())
                .star(Math.round(review.getScore()))
                .storeId(review.getStore().getId())
                .build();
    }
}
