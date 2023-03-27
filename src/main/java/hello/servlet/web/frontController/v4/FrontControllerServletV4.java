package hello.servlet.web.frontController.v4;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v3.ControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontController.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontController.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontController.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {
    private Map<String, ControllerV4> controllerV3Map= new HashMap<>();

    public FrontControllerServletV4() {
        controllerV3Map.put("/front-controller/v4/new-form", new MemberFormControllerV4());
        controllerV3Map.put("/front-controller/v4/save", new MemberSaveControllerV4());
        controllerV3Map.put("/front-controller/v4/members", new MemberListControllerV4());
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        ControllerV4 controllerV4 = controllerV3Map.get(requestURI);

        if (controllerV4==null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // paramMap을 넘겨주기
        Map<String, String> paraMap = createParamMap(req);
        Map<String, Object> model= new HashMap<>();
        String viewName = controllerV4.process(paraMap, model);

        // 논리 이름을 물리 이름으로 변환하자! -> viewResolver의 역할!
        MyView view = viewResolver(viewName);
        view.render(model,req,resp);
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
