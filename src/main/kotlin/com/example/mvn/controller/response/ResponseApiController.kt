package com.example.mvn.controller.response

import com.example.mvn.controller.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/response")

class ResponseApiController {

    // 추상화

//    fun <T: Any> checkResponse(requestBody: T?, checkError: (arg: T) -> Boolean
//    ): ResponseEntity<T> {
//        return requestBody?.let {
//            if (checkError(requestBody)) {
//                return ResponseEntity.status(400).body("Error")
//            }
//
//            ResponseEntity.ok(requestBody)
//        } ?: kotlin.run {
//            return ResponseEntity.status(400).body("fail")
//        }
//    }
    // 1. get 4xx
    // GET /api/response

    @GetMapping("")
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {

        return age?.let {
            // age != null
            if (it < 20) {
                return ResponseEntity.status(400).body("age 값은 20 보다 커야 함")
            }

            ResponseEntity.ok("OK")
        } ?: kotlin.run {
            // age == null
            return ResponseEntity.status(400).body("fail")
        }
    }


    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(200).body(userRequest)
    }

    @PutMapping("")
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        // 기존 데이터 부재로 새로 생성
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id :Int): ResponseEntity<Any> {
        return ResponseEntity.status(500).body(null)
    }
}