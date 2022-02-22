package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {
@RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
    ModelAndView maV = new ModelAndView("response/hello")
            .addObject("data", "hello!");
    return maV;
}

@RequestMapping("response-view-v2")
    public String responseViewV2(Model model){
    model.addAttribute("data", "hello!");
    return "response/hello";
    //string을 반환하면 뷰의 논리적인 이름이 된다
}
    @RequestMapping("response/hello")
    public void responseViewV3(Model model){
        model.addAttribute("data", "hello!");
        //@Controller를 사용하고, Http 메세지 바디를 처리하는 파라미터도 없으면, 요청 url 참고해서
        //논리뷰 이름으로 사용, 권장x
    }

}
