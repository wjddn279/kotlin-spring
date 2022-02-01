package com.example.mvn.controller.page

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
// @Controller annotation: static 하위에 resource를 찾는다
// @RestController 와 차
class PageController {

    @GetMapping("/main")
    fun main(): String {
       println("int main")
       return "main.html"
    }

    @ResponseBody // json mappint
    @GetMapping("/test")
    fun response(): String{
        return "main.html"
    }
}