package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // 쿼리 파라미터를 넣으면 어떻게 될까?
        String username= request.getParameter("username");
        System.out.println("username = " + username);

        // 이거는 헤더에 들어감!
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        response.getWriter().write("hello "+ username);

        // 요청메시지를 다 보고 싶다면?

    }
}
