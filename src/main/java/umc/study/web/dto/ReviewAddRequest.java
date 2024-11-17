package umc.study.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewAddRequest {
    private String comment; // 리뷰 내용
    private Integer star;   // 평점
    private Long storeId;   // Store ID
}
