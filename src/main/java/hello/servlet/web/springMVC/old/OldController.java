package hello.servlet.web.springMVC.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


@Component("/springMVC/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldeContoller.handlerRequest");
        return new ModelAndView("new-form");
    }
    // Component에 url을 적음
    // 핸들러매핑해서 이 컨트롤러를 찾아야함!
    // 호출에는 2가지가 필요!
    // 스프링 빈의 이름으로 핸들러를 찾을 수 있고
    // Controller 인터페이스를 실행할 수 있는 핸들러 어댑터도 필요!!

    // @붙은 어노테이션 붙은 @RequestMapping이 되어있으면 핸들러 매핑!
    // 아니면 위처럼 스프링 빈에 이름이 url인걸 찾음!

    // 그 후 spring이 어댑터에서 supports를 순서대로 호출

}
