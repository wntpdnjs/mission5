package umc.study.validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.repository.StoreRepository.StoreRepository;

@Component
@RequiredArgsConstructor
public class ExistStoreValidator implements ConstraintValidator<umc.study.validation.ExistStore, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        // Store가 존재하는지 확인
        if (storeId == null) {
            return false; // Null인 경우 유효하지 않음
        }
        return storeRepository.existsById(storeId);
    }
}
