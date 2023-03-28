package hello.servlet.web.frontController.v5.adapter;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.v3.ControllerV3;
import hello.servlet.web.frontController.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandelrAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        // controller V3라는걸 알려줌 true를 반환!
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest re, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV3 controllerV3 =(ControllerV3) handler;

        Map<String,String> papramMap = createParamMap(re);
        ModelView mv = controllerV3.process(papramMap);
        return null;
    }

    private static Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String,String> paraMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName ->paraMap.put(paramName, req.getParameter(paramName)));
        return paraMap;
    }
}
