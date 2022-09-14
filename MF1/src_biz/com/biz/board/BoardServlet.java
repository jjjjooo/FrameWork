package com.biz.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BoardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /** (프론트 서블릿이 존재하기 이전)
         *  서블릿만 사용하던 시절은 특정 파라매터를 가지고 서비스를 분기했다.
         *  톰캣에 등록되는 서블릿 객체가 무겁고 관리가 어려워 제어를 위한 분기이다.
         */
        String mode = request.getParameter("mode");
        PrintWriter out = response.getWriter();

        if ("callList".equals(mode)) {
            callList(request, out);
            return;
        }

        if ("callWrite".equals(mode)) {
            callWrite(request, out);
            return;
        }

        if ("exeWrite".equals(mode)) {
            exeWrite(request, out);
            return;
        }

        out.println("mode=" + mode);

    }

    /**
     * 입력의 크기는 예측 가능하기 때문에 서블릿 request
     * 출력은 크기가 예측이 불가능하기 때문에 stream 객체(PrintWriter) 통해 해결한다.
     */
    void callList(HttpServletRequest request, PrintWriter out) {
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>this View callList</h2>");
        out.println("<h3>HTML</h3>");
        out.println("</body>");
        out.println("</html>");
    }


    void callWrite(HttpServletRequest request, PrintWriter out) {
        out.print("this View callWrite");
    }


    void exeWrite(HttpServletRequest request, PrintWriter out) {
        out.println("exeWrite ok");
        callList(request, out);
    }

}


