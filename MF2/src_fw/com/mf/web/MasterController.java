package com.mf.web;

import com.biz.board.Board;
import com.mf.data.Box;
import com.mf.data.BoxHttp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 스프링부트 기반의 내장 톰캣으로 개발할 수도 있고,
 * 운영환경의 WAS에서 실행할 수 있으므로 web.xml에 마스터 컨트롤러를 등록하여 개발
 * */
public class MasterController extends HttpServlet {

    /**
     * MVC 패턴에서 어떤 서비스를 호출할지 (=controller) 결정해주는
     * 프론트 컨트롤러이다 = 디스패쳐 서블릿
     * BoardServlet과 다르게 URL로 분기한다.
     * 서블릿이 여러개 있으면 관리가 어렵기 때문에 마스터컨트롤러만 간략하게함
     * 스프링에서는 이 부분이 디스패쳐서블릿과 핸들러 맵핑, 핸들러 어댑팅에 속함
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Box box = new BoxHttp(request);
        BoxContext.set(box);

        try{
            String pathInfo = request.getPathInfo();
            String jspUrl = null;

            if ("/callList".equals(pathInfo)) {

                Board board = new Board();
                jspUrl = board.callList();

            } else if ("/callWrite".contentEquals(pathInfo)) {

                Board board = new Board();
                jspUrl = board.callWrite();

            } else if ("/exeWrite".contentEquals(pathInfo)) {

                Board board = new Board();
                jspUrl = board.exeWrite();

            }

            if (jspUrl == null) {
                throw new ServletException();
            }

            /**
             *
             * */
            RequestDispatcher dispatcher = request.getRequestDispatcher(jspUrl);
            dispatcher.forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            BoxContext.remove();
        }



    }

}
