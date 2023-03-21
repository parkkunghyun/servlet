package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeader(request);
    }
    private static void printStartLine(HttpServletRequest request) {
        // http 첫라인 불러오기!
        System.out.println("---- REQUEST LINE - start ----");
        System.out.println("request.getMethod()"+ request.getMethod());
        System.out.println("request.getProtocol()"+ request.getProtocol());
        System.out.println("request.getScheme()"+ request.getScheme());
        System.out.println("request.getServerName"+ request.getServerName());
        System.out.println("request.getServerPort" +request.getServerPort());

        // http://localhost:8080/request-header
        System.out.println("request.getURL()"+ request.getRequestURL());
        System.out.println("request.getURI()"+ request.getRequestURI());

        // /request-test
        //username=hi
        System.out.println("request.getQueryString()"+ request.getQueryString());
        System.out.println("https 사용인지"+ request.isSecure());
        System.out.println("---- REQUEST LINE end ---");
        System.out.println();

        // cookie
        System.out.println("cookie 편의 조회");
        if(request.getCookies() != null) {
            for (Cookie cookie: request.getCookies()) {
                System.out.println("cookie.getName() + cookie.getValue() = " + cookie.getName() + cookie.getValue());
            }
            System.out.println();
        }
    }
    private void printHeader(HttpServletRequest request) {
        System.out.println("--- headers - start");
       /*
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println("headerName = " + headerName);
        }
       */
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println("headerName = " + headerName));

        System.out.println("---headers - end 00-");
        System.out.println();
    }

}
