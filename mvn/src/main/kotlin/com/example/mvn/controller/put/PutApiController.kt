package com.example.mvn.controller.put

import com.example.mvn.model.http.UserRequest
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController {

    // @PutMapping

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "request-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/put-mapping]"])
    fun requestMappingPut(): String {
        return "request-mapping"
    }

    @PutMapping("/put-mapping/object")
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest, bindingResult: BindingResult): ResponseEntity<String> {

        if (bindingResult.hasErrors()) {
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append(field.toString()+" : "+message)
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }

        return ResponseEntity.ok("ok")

//        return ApiResponse().apply {
//            // 1. result
//            this.result = Result().apply {
//                this.resultCode = "OK"
//                this.resultMessage = "성공"
//            }
//        }.apply {
//            // 2. description
//            this.description = "~~~~~~~~~"
//
//        }.apply {
//            // 3. user mutable list
//            val userList = mutableListOf<UserRequest>()
//            userList.add(userRequest)
//            userList.add(UserRequest().apply {
//                this.name = "a"
//                this.age = 10
//                this.email = "a@gmail.com"
//                this.address = "a address"
//                this.phoneNumber = "010-1111-aaaa"
//            })
//            userList.add(UserRequest().apply {
//                this.name = "b"
//                this.age = 20
//                this.email = "b@gmail.com"
//                this.address = "b address"
//                this.phoneNumber = "010-1111-bbbb"
//            })
//
//            this.userRequest = userList
//        }
    }
}