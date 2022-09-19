package com.mf.data;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class BoxHttp extends Box{


    private static final long serialVersionUID=1L;

    /**
     * WAS에서 동작 하는 코드
     * 이미 있는 구현체이기 때문에 생성자를 통해 인스턴스를 얻어옴
     */
    private HttpServletRequest request = null;

    public BoxHttp(HttpServletRequest request){
        this.request = request;
    }

    @Override
    public void set(String key, Object object) {
        request.setAttribute(key, object);
    }

    @Override
    public Object get(String key){

        /**
         *  서비스 로직에서 가공된 Request를 선순위로 둔다.
         */
        Object obj = request.getAttribute(key);
        if(obj != null){
            return obj;
        }

        /**
         *   사용자가 넘겨준 Request를 후순위로 둔다.
         */
        return request.getParameter(key);
    }
}
