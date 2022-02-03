package com.example.mvn.annotation

import com.example.mvn.validator.StringFormatDateTimeValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [StringFormatDateTimeValidator::class])
@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented

annotation class StringFormatDateTime (
    val pattern: String = "yyyy-MM-dd HH:mm:ss",
    val message: String = "시간 형식 유효하지 않음",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)