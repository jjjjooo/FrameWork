package com.mf.web;

import java.io.File;

import javax.servlet.http.HttpServlet;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import com.biz.board.BoardServlet;


public class RunBy {

    public static void main(String[] args) throws Exception {


        String root = new File(".").getAbsolutePath();
        // 동작하는지 확인하기 위한 임시 폴더
        String baseDir = root + File.separatorChar + "temp";

        int webPort = 18082;

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(webPort);

        tomcat.setBaseDir(baseDir);
        tomcat.setPort(webPort);

        //컨텍스트 등록
        //컨텍스트 맵핑
        //web.xml server.xml의 하드 코딩 형태
        Context context = tomcat.addContext("/", baseDir);

        HttpServlet board = new BoardServlet();

        tomcat.addServlet("/", "board", board);

        // http://localhost:18082/board?mode=callList(등등)
        context.addServletMappingDecoded("/board", "board");

        tomcat.start();
        tomcat.getServer().await();

    }
}

