package umc.study.service.UserService;

import jakarta.transaction.Transactional;
import umc.study.domain.Review;
import umc.study.web.dto.ReviewAddRequest;
import umc.study.web.dto.UserResponseDto;

public interface reviewService {
    @Transactional
    Review ReviewAdd(Long userId, ReviewAddRequest request);
    UserResponseDto.ReviewDto toJoinResultDTO(Review review);
}
