package com.example.mvn.controller.exception

import com.example.mvn.model.http.UserRequest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.util.LinkedMultiValueMap

@WebMvcTest
@AutoConfigureMockMvc
class ExceptionApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun helloTest(){
        mockMvc.perform(
            get("/api/exception/hello")
        ).andExpect (
            status().`is`(200)
        ).andExpect(
            content().string("hello")
        ).andDo(print())
    }

    @Test
    fun getTest(){
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("name","claude")
        queryParams.add("age", "9")

        mockMvc.perform(
            get("/api/exception").queryParams(queryParams)
        ).andExpect(
            status().isBadRequest
        ).andExpect(
            content().contentType("application/json")
        ).andExpect(
            jsonPath("\$.result_code").value("FAIL")
        ).andExpect(
            jsonPath("\$.errors[0].field").value("age")
        ).andExpect(
            jsonPath("\$.errors[0].field").value("9")
        ).andDo(print())
    }

    @Test
    fun postTest(){

        val userRequest= UserRequest().apply {
            this.name = "claude"
            this.age = 28
            this.phoneNumber = "010-7499-9895"
            this.address = "경기도 수원시"
            this.createdAt = "2020-10-2 13:00"
        }
        val json = jacksonObjectMapper().writeValueAsString(userRequest)
        println(json)

        mockMvc.perform(
            post("/api/exception")
                .content("")
                .contentType("application/json")
                .accept("application/json")
        ).andExpect(
            status().isOk
        ).andDo(print())
    }
}