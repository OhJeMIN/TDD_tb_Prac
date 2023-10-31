package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTest {
    @Test
    @DisplayName("TestUtil.genScanner() 테스트")
    void t1(){
        Scanner scanner = TestUtil.genScanner("""
                등록
                어려운 길은 길이 아니다.
                박명수
                """.stripIndent());
        String cmd = scanner.nextLine();
        String content = scanner.nextLine();
        String authorName = scanner.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("어려운 길은 길이 아니다.");
        assertThat(authorName).isEqualTo("박명수");
    }

    @Test
    @DisplayName("TestUtil.setOutToByteArray() 테스트")
    void t2(){
        //모니터에 대한 출력을 끄는 것
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        System.out.println("2 / 박명수 / 어려운 길은 길이 아니다.");
        String out = byteArrayOutputStream.toString().trim();

        assertThat(out).isEqualTo("2 / 박명수 / 어려운 길은 길이 아니다.");
        //모니터에 대한 출력을 다시 키는 것
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        System.out.println("이제 다시 정상 출력");
    }
}
