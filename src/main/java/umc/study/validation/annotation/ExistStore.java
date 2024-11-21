package umc.study.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.validation.validation.ExistStoreValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistStoreValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStore {
    String message() default "Store does not exist with the given ID.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
