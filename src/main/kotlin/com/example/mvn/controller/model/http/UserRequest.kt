package com.example.mvn.controller.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import javax.validation.constraints.*

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
// 자동으로 snake_case 로 변경₩
data class UserRequest(

    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name:String?= null,

    @field:PositiveOrZero
    var age:Int?= null,

    @field: Email
    var email:String?=null,

    @field:NotBlank
    var address:String?= null,

    @JsonProperty(value = "phone_number") // value 값 기준으로 parsing
    var phoneNumber:String?=null // phone_number case와 호환안됨
)
