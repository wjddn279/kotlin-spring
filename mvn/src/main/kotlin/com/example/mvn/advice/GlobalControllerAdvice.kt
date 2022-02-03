package com.example.mvn.advice

import com.example.mvn.controller.exception.ExceptionApiController
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.RuntimeException

// basePackageClassess: Advice 를 적용시킬 class를 explicit 하게 선
// 따로 선언하지 않는다면 모든 case애 적용되기 때문에  tracking 어려움
@RestControllerAdvice(basePackageClasses = [ExceptionApiController::class])
class GlobalControllerAdvice {

    @ExceptionHandler(value = [RuntimeException::class])
    fun exception(e: RuntimeException): String {
        return "Server Error"
    }

    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }
}