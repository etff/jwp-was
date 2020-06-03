package http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineTest {
    @DisplayName("RequestLine 생성 - 정상")
    @Test
    void create() {
        //given
        String request = "GET /users HTTP/1.1";

        //when
        RequestLine requestLine = RequestLine.parse(request);

        //then
        assertThat(requestLine.getMethod()).isEqualTo("GET");
        assertThat(requestLine.getPath()).isEqualTo("/users");
        assertThat(requestLine.getProtocol()).isEqualTo("HTTP");
        assertThat(requestLine.getVersion()).isEqualTo("1.1");
    }

    @DisplayName("Query String 파싱 - 정상")
    @Test
    void parseQueryString() {
        //given
        String request = "GET /users?userId=javajigi&password=password&name=JaeSung HTTP/1.1";

        //when
        RequestLine parse = RequestLine.parse(request);

        //then
        assertThat(parse.getQuerys()).hasSize(3);
    }
}