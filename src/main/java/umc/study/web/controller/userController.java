package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.Review;
import umc.study.service.UserService.reviewService;
import umc.study.web.dto.ReviewAddRequest;
import umc.study.web.dto.UserResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class userController {

    private final reviewService reviewService;

    @PostMapping("/{userId}/reviews")
    public ApiResponse<UserResponseDto.ReviewDto> createReview(
            @PathVariable Long userId,
            @RequestBody @Valid ReviewAddRequest request) {
        Review review = reviewService.ReviewAdd(userId, request);
        return ApiResponse.onSuccess(reviewService.toJoinResultDTO(review));
    }
}
