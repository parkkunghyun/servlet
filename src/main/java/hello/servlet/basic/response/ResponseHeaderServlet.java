package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setStatus(HttpServletResponse.SC_OK); // 200 status-line
        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        // resp.setHeader("Cache-Control", "no-cache, no-store");
        resp.setHeader("my-header","hello");
        resp.getWriter().write("ok");

        // 직접 header에 넣는게 아닌 방식
        // resp.setContentType("text/plain");
        // resp.setContentLength(200);
        // resp.setCharacterEncoding("utf-8");

        // cookie 관련 메서드
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        resp.addCookie(cookie);

        resp.setStatus(HttpServletResponse.SC_FOUND);
        resp.setHeader("Location", "/basic/hello-form.html");
        // redirect 편의 메서드
       // resp.sendRedirect("/basic/hello-form.html");
    }
}
