package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name ="mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // jsp 경로를 만들고, 컨트롤러에서 뷰로 이동!,
        // forward 하면 서블릿에서 jsp를 호출하는거임, 서버내부에서 view를 호출한거! url은 안바뀜!
        // WEB-INF는 외부에서 부르지 못하고 컨트롤러로만 호출하게!
        // redirect는 그 경로로 url이 바뀜
        String viewPath ="/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher =request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
