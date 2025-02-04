package com.example.ProjectManagment.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD})  // این انوتیشن روی فیلدها استفاده می‌شود
@Retention(RetentionPolicy.RUNTIME)  // این انوتیشن در زمان اجرا قابل دسترسی است
@Constraint(validatedBy = UniqueValidator.class)  // کلاس اعتبارسنجی مرتبط
public @interface UniqueValue {

    String message() default "ایمیل وارد شده تکراری است.";  // پیام پیش‌فرض خطا

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
