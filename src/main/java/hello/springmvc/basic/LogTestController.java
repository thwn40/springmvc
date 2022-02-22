package hello.springmvc.basic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//문자를 반환하면 뷰를 찾는게 아니라 문자를 반환한다
public class LogTestController {
    private final Logger log =  LoggerFactory.getLogger(getClass());

@RequestMapping("/log-test")
    public String logTest(){
    String name = "Spring";
    System.out.println("name = " + name);
    log.trace("trace log = {}", name);
    log.debug("debug log = {}", name);
    log.info("info log = {}", name);
    log.warn("warn log = {}", name);
    log.error("error log = {}", name);
    //로그 레벨을 정할수 있다
    return "ok";
}
}
