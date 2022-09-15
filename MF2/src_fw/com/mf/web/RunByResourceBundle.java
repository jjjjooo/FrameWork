package com.mf.web;

import org.apache.catalina.startup.Tomcat;

import java.util.ResourceBundle;

public class RunByResourceBundle {

    public static void main(String[] args) throws Exception {

        /**
         *  필요 자원 목록
         * */
        String classpath = System.getProperty("java.class.path");
        String[] classpaths = classpath.split(";");
        for (int i = 0; i < classpaths.length; i++) {
            System.out.println(classpaths[i]);
        }

        // 클래스 패스에서 프로퍼티 파일 찾음
        // C:/FrameWork/web/WEB-INF/classes/ + com/mf/web/init.properties
        ResourceBundle init = ResourceBundle.getBundle("com.mf.web.init");

        String webappDir = init.getString("webappDir");
        System.out.println("webappDir = " + webappDir);
        String baseDir = init.getString("baseDir");
        System.out.println("baseDir = " + baseDir);
        int webPort = Integer.parseInt(init.getString("webPort"));

        Tomcat tomcat = new Tomcat();

        tomcat.addWebapp("", webappDir);

        // baseDir + /WEB-INF/web.xml
        tomcat.setBaseDir(baseDir);

        tomcat.setPort(webPort);

        tomcat.start();
        System.out.println("start");
        tomcat.getServer().await();

    }
}
