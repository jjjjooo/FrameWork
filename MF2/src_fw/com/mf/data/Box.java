package com.mf.data;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.Serializable;

public abstract class Box implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 입력
     */
    public abstract void set(String key, Object object);


    /**
     * 출력
     */
    public abstract Object get(String key);

}
