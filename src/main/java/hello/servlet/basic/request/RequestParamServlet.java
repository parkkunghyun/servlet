package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns ="/request-param" )
public class RequestParamServlet extends HttpServlet {
    //
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("전체 파라미터 조회 - start ");
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println("paramName = " + paramName+ "===" + request.getParameter(paramName)));
        System.out.println("전체 파라미터 조회 - end ");
        System.out.println();

        System.out.println("단일 파라미터 조회 - start");
        String username = request.getParameter("username");
        System.out.println(username + " = usernames");
        System.out.println("단일 파라미터 조회 - end");
        
        // username=hello&username=hello2도 가능! 내부 우선순위에서 먼저 있는애가 나옴!
        // 복수 파라미터 조회!
        String [] usernames= request.getParameterValues("username");
        for (String username1: usernames) {
            System.out.println("username1 = " + username1);
        }
        response.getWriter().write("ok");
    }
}
