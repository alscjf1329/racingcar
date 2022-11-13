package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarListCreateTest {

    CarListCreate service = new CarListCreate();

    @Test
    @DisplayName("자동치 이름을 입력받으면 리스트로 반환한다.")
    void test1() {
        // Given
        var carName = "자동차름";

        // When
        var result = service.createList(carName);

        // Then
        assertThat(result).contains(carName);
    }


    @Test
    @DisplayName("자동차 이름은 쉼표로 구분하여 입력받는다.")
    void test2() {
        // Given
        var carNames = "자동이름,새로운름,허허,abc3";

        // When
        var result = service.createList(carNames);

        // Then
        assertThat(result).contains("자동이름", "새로운름", "허허", "abc3");

    }

    @ParameterizedTest
    @ValueSource(strings = {"12345", "가나다라마", "abcde", "dwqjopdqwpdqwjpdo", ""})
    @DisplayName("자동차의 이름은 1글자에서 4글자 사이가 아니면 예외를 반환해야한다.")
    void test6(String name) {
        // when
        var exception = catchThrowable(() -> service.createList(name));

        // then 예외가 터졌으면 좋겠어요
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"이름,", ",a", "a,b,c,", ",ab"})// TODO "1,,"
    @DisplayName("자동차 이름 문자열을 입력할 떄, 쉼표 수가 맞지않으면 예외를 반환하다.")
    void test4(String name) {
        var exception = catchThrowable(() -> service.createList(name));

        // then 예외가 터졌으면 좋겠어요
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("쉼표 개수는 자동차개수-1 이어야 한다.")
    void test6() {

    }

    @Test
    @DisplayName("자동차의 이름은 공백을 포함하면 안된다.")
    void test7() {

    }
}