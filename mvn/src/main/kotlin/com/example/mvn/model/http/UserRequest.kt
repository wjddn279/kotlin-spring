package com.example.mvn.model.http

import com.example.mvn.annotation.StringFormatDateTime
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
    var phoneNumber:String?=null, // phone_number case와 호환안됨

    @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "날짜 패턴이 아닙니다.")
    var createdAt:String?= null
) {

//    @AssertTrue(message = "생성자의 패턴은 yyyy-MM-dd HH:mm:ss 여야 합니다.")
//    // asdasdasdasdsa
//    private fun isValidCreatedAt(): Boolean{
//
//        return try {
//            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
//            true
//        } catch (e: Exception) {
//            false
//        }
//    };

}
