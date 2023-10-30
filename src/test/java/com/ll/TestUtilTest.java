package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


}
