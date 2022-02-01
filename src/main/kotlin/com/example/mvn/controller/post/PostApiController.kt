package com.example.mvn.controller.post

import com.example.mvn.controller.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostApiController {

    // @PostMapping
    // @RequestBody Request body 부분 parsing
    // @JsonProperty : json naming
    // @JsonNaming: class json naming

    @PostMapping("/post-mapping")
    fun postMapping(): String{
        return "post-mapping"
    }

    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    // body 의 data parsing
    // object mapper : json -> object, object -> json

    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest{
        return userRequest;
    }
}