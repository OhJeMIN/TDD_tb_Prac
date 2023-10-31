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

    @Test
    @DisplayName("등록을 할때마다 번호 증가")
    void t4(){
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        Scanner scanner = TestUtil.genScanner("""
                등록
                늦었다고 생각할 때가 제일 늦다.
                박명수
                등록
                어려운 길은 길이 아니다.
                박명수
                종료
                """.stripIndent());

        new App(scanner).run();
        scanner.close();

        String rs  = byteArrayOutputStream.toString();

        assertThat(rs).contains("2번 명언이 등록되었습니다.");
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
    }

    @Test
    @DisplayName("목록 입력하면 목록이 번호 /작가 /명언 순으로 나오게 한다.")
    void t5(){
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        Scanner scanner = TestUtil.genScanner("""
                등록
                늦었다고 생각할 때가 제일 늦다.
                박명수
                등록
                어려운 길은 길이 아니다.
                박명수
                목록
                종료
                """.stripIndent());

        new App(scanner).run();
        scanner.close();

        String rs  = byteArrayOutputStream.toString();

        assertThat(rs).contains("2 / 박명수 / 어려운 길은 길이 아니다.");
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
    }

    @Test
    @DisplayName("명령문 뒤에? 를 제거하고 명령 알아듣기")
    void t6(){
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        Scanner scanner = TestUtil.genScanner("""
                등록
                늦었다고 생각할 때가 제일 늦다.
                박명수
                등록
                어려운 길은 길이 아니다.
                박명수
                목록
                삭제?
                종료
                """.stripIndent());

        new App(scanner).run();
        scanner.close();

        String rs  = byteArrayOutputStream.toString().trim();

        assertThat(rs).contains("id가 없습니다.");
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
    }

    @Test
    @DisplayName("명령문 뒤에? 를 제거하고 명령들 중 id값 받아오기")
    void t7(){
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        Scanner scanner = TestUtil.genScanner("""
                등록
                늦었다고 생각할 때가 제일 늦다.
                박명수
                등록
                어려운 길은 길이 아니다.
                박명수
                목록
                삭제?id=1&author=박명수
                종료
                """.stripIndent());

        new App(scanner).run();
        scanner.close();

        String rs  = byteArrayOutputStream.toString().trim();
        assertThat(rs).contains("1번 명언이 삭제되었습니다.");
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
    }
}
