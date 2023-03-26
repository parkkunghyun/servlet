package hello.servlet.web.frontController.v3;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
    private Map<String, ControllerV3> controllerV3Map= new HashMap<>();

    public FrontControllerServletV3() {
        controllerV3Map.put("/front-controller/v3/new-form", new MemberFormControllerV3());
        controllerV3Map.put("/front-controller/v3/save", new MemberSaveControllerV3());
        controllerV3Map.put("/front-controller/v3/members", new MemberListControllerV3());
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        ControllerV3 controllerV3 = controllerV3Map.get(requestURI);

        if (controllerV3==null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // paramMap을 넘겨주기
        Map<String, String> paraMap = createParamMap(req);
        ModelView mv = controllerV3.process(paraMap);

        // 논리 이름을 물리 이름으로 변환하자! -> viewResolver의 역할!
        String viewName =mv.getViewName();
        MyView view = viewResolver(viewName);
        view.render(mv.getModel(), req,resp);
    }
    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String,String> paraMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName ->paraMap.put(paramName, req.getParameter(paramName)));
        return paraMap;
    }
}
