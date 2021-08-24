package com.scores.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 用于验证用户类型是否在指定范围内的注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = FlagValidatorImpl.class)
public @interface FlagValidator {
    String[] value() default {};

    String message() default "flag is not found";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
