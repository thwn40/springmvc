package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age  =Integer.parseInt(request.getParameter("age"));
        log.info("username = {}, age= {}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody// 뷰조회를 진행하지 않게 해줌
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ){
        log.info("username={}, age={}", memberName,memberAge);
        return "ok";

    }
    @ResponseBody // 변수명이 똑같으면 생략 가능하다
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ){
        log.info("username={}, age={}", username,age);
        return "ok";

    }
    @ResponseBody // 요청 파라미터랑 같으면(단순타입만) 사실 다 생략 가능
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            String username,
            int age
    ){
        log.info("username={}, age={}", username,age);
        return "ok";

    }
    @ResponseBody // 요청 파라미터랑 같으면(단순타입만) 사실 다 생략 가능
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) int age
    ){
        log.info("username={}, age={}", username,age);
        return "ok";
    }
    @ResponseBody //기본값이 설정됨 빈문자까지 처리해줌
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "guest") String username,
            @RequestParam(defaultValue = "-1") int age
    ){
        log.info("username={}, age={}", username,age);
        return "ok";
    }

    @ResponseBody //기본값이 설정됨 빈문자까지 처리해줌
    @RequestMapping("/request-param-map")
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap
    ){
        log.info("username={}, age={}", paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){


        log.info("username={}, age={}",helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);
        return "ok";

    }

    //단순 타입 @RequestParam, 나머지 ModelAttribute
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        log.info("username={}, age={}",helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);
        return "ok";

    }
}
