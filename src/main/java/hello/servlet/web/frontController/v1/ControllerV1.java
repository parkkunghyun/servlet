package hello.servlet.web.frontController.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV1 {
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    // 이걸만들어서 회원폼 컨트롤러, 회원 조회 컨트롤러 전부 이걸로 구현!
    // servlet과 비슷한 모양의 컨트롤러 인터페이스를 도입!
}
