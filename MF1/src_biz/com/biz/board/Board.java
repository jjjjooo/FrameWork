package com.biz.board;

import javax.servlet.http.HttpServletRequest;

public class Board {

    /**
     * 서블릿의 Request는 MVC1 패턴에서 M, model로 상정한다.
     * */
    public String callList(HttpServletRequest request) {

        String findStr = request.getParameter("findStr");

        System.out.println(findStr);

        //현재 뷰 리졸버를 쓰지 않기 때문에 웹 어플리 케이션의 절대 경로 반환 해줘야한다.
        //JSP 사용 전에 이 부분을 PrintWriter 스트림을 이용하여 HTML을 반환했다.
        return "/WEB-INF/classes/com/biz/board/jsp/list.jsp";
    }

    public String callWrite(HttpServletRequest request) {

        return "/WEB-INF/classes/com/biz/board/jsp/write.jsp";

    }

    public String exeWrite(HttpServletRequest request) {

        request.setAttribute("exeWriteResult", "ok");

        return callList(request);
    }
}
