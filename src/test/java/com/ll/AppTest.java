package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    @DisplayName("종료 입력하면 프로그램 꺼짐.")
    void t1() {
        Scanner scanner = TestUtil.genScanner("""
                종료
                """.stripIndent());

        new App(scanner).run();

        scanner.close();
    }

    @Test
    @DisplayName("등록을 입력하면 명언과 작가를 입력받는다.")
    void t2(){
        Scanner scanner = TestUtil.genScanner("""
                등록
                늦었다고 생각할 때가 제일 늦다.
                박명수
                종료
                """.stripIndent());

        new App(scanner).run();
        scanner.close();
    }

    @Test
    @DisplayName("등록을 완료하면 1번 명언이 등록되었습니다.")
    void t3(){
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        Scanner scanner = TestUtil.genScanner("""
                등록
                늦었다고 생각할 때가 제일 늦다.
                박명수
                종료
                """.stripIndent());

        new App(scanner).run();
        scanner.close();

        String rs  = byteArrayOutputStream.toString();

        assertThat(rs).contains("1번 명언이 등록되었습니다.");
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
    }
}