package umc.study.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.ReviewAddRequest;
import umc.study.web.dto.UserResponseDto;

@Service
@RequiredArgsConstructor
public class reviewServiceImpl implements reviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final ReviewConverter reviewConverter;

    @Override
    @Transactional
    public Review ReviewAdd(Long userId, ReviewAddRequest request) {
        // Store 조회
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found with ID: " + request.getStoreId()));

        // DTO -> 엔티티 변환
        Review review = reviewConverter.toEntity(userId, request, store);

        // 데이터베이스에 저장
        return reviewRepository.save(review);
    }

    @Override
    public UserResponseDto.ReviewDto toJoinResultDTO(Review review) {
        return reviewConverter.toJoinResultDTO(review);
    }
}
