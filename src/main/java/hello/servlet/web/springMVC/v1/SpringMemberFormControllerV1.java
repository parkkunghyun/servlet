package hello.servlet.web.springMVC.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
// 스프링이 자동으로 스프링 빈으로 등록
// 내부에 @Component 있어서, 이거면 컴포넌트 스캔의 대상!
// RequestMappingHandlerMapping은
// 스프링 빈 중에서 @RequestMapping 또는 @Controller가 클래스 레벨에 붙어있는 경우 매핑 정보로 인식!

// @Componet, @RequestMapping클래스에 둘다 적으면 스프링 빈도 등록되고 매핑도 해줌!
// 핵심은 RequestMappingHandlerMapping의 대상이면 매핑 해줌!
public class SpringMemberFormControllerV1 {
    // @RequestMapping은 요청정보를 매핑, 해당 url이 호출되면 이 메서드가 호출!
    //
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
