package com.mf.web;

import com.mf.data.Box;
import com.mf.data.BoxLocal;

public class BoxContext {

    /**
     *
     */
    private static ThreadLocal<Box> TL = new ThreadLocal<Box>();

    /**
     * 마스터 컨트롤러에서 제어
     */
    static void set(Box box) {
        TL.set(box);
    }

    /**
     * 마스터 컨트롤러에서 제어
     */
    static void remove() {
        TL.remove();
    }

    /**
     * 제어 없이 사용하면 NULL일 수 있음
     * 단일에서는 제어가 필요없음,
     */
    public static Box get() {

        Box box = TL.get();

        if (box != null) {
            return box;
        }

        // set() 메소드가 호출 안된 경우
        // 독립적 프로그램, 테스트 유닛
        // 개발자는 실행하는 환경에 의존하지 않는 코드를 만들 수 있음
        box = new BoxLocal();
        set(box);
        return box;
    }

}
