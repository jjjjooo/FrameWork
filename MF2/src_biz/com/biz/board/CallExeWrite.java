package com.biz.board;

import com.mf.data.Box;
import com.mf.web.BoxContext;

public class CallExeWrite {

    public static void main(String[] args) {

        /**
         *  WAS 없이 독립적으로 실행 중...
         *  ABCD + i 라는 자원을 DB에 저장하고 있다고 가정
         *  일종의 테스트 코드
         */
        Box box = BoxContext.get();
        box.set("txt", "ABCD");

        Board b = new Board();
        b.exeWrite();

        for(int i = 0; i<5;i++){
            box.set("txt", "ABCD" +i);
            b.exeWrite();
        }
    }
}
