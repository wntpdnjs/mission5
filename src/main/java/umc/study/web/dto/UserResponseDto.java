package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto {
    @Getter
    @Builder
    public static class ReviewDto {
        private Long userId;    // 사용자 ID
        private String comment; // 리뷰 내용
        private Integer star;   // 평점
        private Long storeId;   // Store ID
    }
}
