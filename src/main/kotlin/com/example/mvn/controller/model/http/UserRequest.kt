package com.example.mvn.controller.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
// 자동으로 snake_case 로 변경₩
data class UserRequest (
var name:String?= null,
var age:Int?= null,
var email:String?=null,
var address:String?= null,

@JsonProperty(value = "phone_number") // value 값 기준으로 parsing
var phoneNumber:String?=null // phone_number case와 호환안됨
)
