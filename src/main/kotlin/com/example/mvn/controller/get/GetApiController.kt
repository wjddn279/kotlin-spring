package com.example.mvn.controller.get

import com.example.mvn.controller.model.http.UserRequest
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println
import org.springframework.web.bind.annotation.*

@RestController     // Rest API Controller 동작시키는 annotation
@RequestMapping("/api") // :8080/api 로 매핑
class GetApiController {


    // @RequestController : Rest APi 를 설정
    // @RequestMapping : 리소스를 설정 (method로 구분 가능)

    // @GetMapping Get Resource 설정
    // @RequestParam: URL query param Parsing
    // @PathVariable: URL Path variable Parsing
    // Object: Query Param Object 로 parsing

    @GetMapping(path = ["/hello", "/abcd"])
    // :8080/api/hello, :8080/api/abcd 로 get mapping
    fun hello(): String {
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"]) //
    fun  requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    // GET 8080/api/get-mapping/path-variable/claude
    // @PathVariable 로 name을 name (일치해야 함) 에 mapping
    fun pathVaribable(@PathVariable name: String, @PathVariable age: Int): String {
        println("${name},${age}")
        return name
    }

    @GetMapping("/get-mapping2/path-variable/{name}/{age}")
    // pathVariable 과 변수명 겹치는 경우
    // value = age 로 PathVariable을 명시 후 변수 따로 명시
    fun pathVaribable2(@PathVariable(value = "name") _name: String, @PathVariable(value = "age") _age: Int): String {
        println("${_name},${_age}")
        return _name
    }


    // guery paramater parsing
    // :8080/api/page?key=value&key=val&key=val
    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam name: String,
        @RequestParam(value = "age") age: Int
    ): String {
        println("${name}, ${age}")

        return name + " " + age
    }

    // name, age, adress, email
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest{
        // object 형태가 자동으로 json 으로 변경됨
        return userRequest
    }

    // map 형태로 받음
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any>{
        val phoneNumber = map["age"]
        return map
    }
}