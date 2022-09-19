package com.biz.board;

import com.mf.data.Box;
import com.mf.web.BoxContext;

import javax.servlet.http.HttpServletRequest;


/**
 * WAS에 의존적 HttpServeltRequest를 사용함
 *
 * */
public class Board {


    public String callList() {

        Box box = BoxContext.get();

        /**
         *  box의 get(),set() 서비스로직을 실행 중...
         *  findStr을 찾아서 가공해서 list로 DB에 넣는다 정도로 생각
         */
        String findStr = (String) box.get("findStr");
        box.set("list", "list =[" + findStr + "]");

        return "/WEB-INF/classes/com/biz/board/jsp/list.jsp";
    }

    public String callWrite() {

        return "/WEB-INF/classes/com/biz/board/jsp/write.jsp";

    }

    public String exeWrite() {

        /**
         *  DB에 저장하는 함수
         */
        Box box = BoxContext.get();

        String txt = (String) box.get("txt");

        System.out.println("exeWrite [" + txt + "]");

        box.set("exeWriteResult", "ok");

        return callList();
    }
}
