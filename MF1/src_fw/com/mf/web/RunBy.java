package com.mf.web;

import java.io.File;
import javax.servlet.http.HttpServlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import com.biz.board.BoardServlet;


public class RunBy {

    public static void main(String[] args) throws Exception {

        /**
         * 톰캣 생성
         * contextPath와 docBase 폴더 지정
         * */
        String root = new File(".").getAbsolutePath();
        // 동작하는지 확인하기 위한 임시 폴더
        String baseDir = root + File.separatorChar + "temp";


        int webPort = 18082;

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(webPort);

        tomcat.setBaseDir(baseDir);
        tomcat.setPort(webPort);

        /**
         * 컨텍스트 등록
         * 서블릿을 톰캣에 등록 + URL 맵핑
         * */
        Context context = tomcat.addContext("/", baseDir);

        HttpServlet board = new BoardServlet();

        tomcat.addServlet("/", "board", board);

        // http://localhost:18082/board?mode=callList(등등)
        context.addServletMappingDecoded("/board", "board");

        tomcat.start();
        tomcat.getServer().await();

    }
}

