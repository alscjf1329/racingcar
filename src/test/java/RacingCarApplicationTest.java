import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.event.CaretListener;

import static org.assertj.core.api.Assertions.*;

/**
 * - 자동차 이름을 입력 받아 자동차를 생성
 * - 1대 이상의 자동차가 존재해야한다.
 * - 자동차 이름에 공백이 들어오면 안된다.
 * - 자동차 이름은 1자 ~ 5자 사이여야 한다.
 * - 자동차 초기 위치는 출발점이어야 한다.
 * - 중복된 이름의 자동차가 존재할 수 없다.
 * - 쉼표의 개수와 자동차 이름의 개수가 맞아야한다.
 */
class RacingCarApplicationTest {
    @Test
    @DisplayName("자동차 이름을 입력 받아 자동차를 생성")
    void test1() {
        String string = "에쿠스";
        var result = new Car(string);
        assertThat(result.toString()).contains("에쿠스");
    }

    @Test
    @DisplayName("1대 이상의 자동차가 존재해야한다.")
    void test2() {
        String string = "";
        var result = new CarList(string);
        result.printCarNameList();
        assertThat(result.toString());
    }

    @Test
    @DisplayName("자동차 이름에 공백이 들어오면 안된다.")
    void test3() {
        String string = "";
        var result = new Car(string);
        assertThat(result.toString());
    }

    @Test
    @DisplayName("자동차 이름은 1자 ~ 5자 사이여야 한다. (true)")
    void test4() {
        String string = "sdf,asdf,sdafa";
        var result = new CarList(string);
        result.printCarNameList();
        assertThat(result.toString());
    }

    @Test
    @DisplayName("자동차 이름은 1자 ~ 5자 사이여야 한다. (false)")
    void test5() {
        String string = ",asldfda,fasdfasadf";
        var result = new CarList(string);
        result.printCarNameList();
        assertThat(result.toString());
    }

    @Test
    @DisplayName("중복된 이름의 자동차가 존재할 수 없다.")
    void test6() {
        String string = "asdf,asdf,asdf,sflk";
        var result = new CarList(string);
        result.printCarNameList();
        assertThat(result.toString());
    }

    @Test
    @DisplayName("쉼표의 개수와 자동차 이름의 개수-1이 맞아야한다.")
    void test7() {
        String string = "asas,dsfg,sdfg,sef";
        var result = new CarList(string);
        result.printCarNameList();
        assertThat(result.toString());
    }

    @Test
    @DisplayName("사용자에게 전진 시도를 몇 번 할 것인지 입력받는다")
    void test8() {
        String string = "asas,dsfg,sdfg,sef";
        var carList = new CarList(string);
        CarService carService = new CarService(carList, 1);
        carService.printRaceResult(3);
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차의 이름을 출력한다.")
    void test9() {
        String string = "asas,dsfg,sdfg,sef";
        var carList = new CarList(string);
        CarService carService = new CarService(carList, 1);
        carService.printRaceResult(3);
        Release.printTheMostMovedCars(carList);
    }

    @Test
    @DisplayName("동점자가 있는 경우 모두 출력한다.")
    void test10() {
        String string = "asas,dsfg,sdfg,sef";
        var carList = new CarList(string);
        CarService carService = new CarService(carList, 1);
        carService.printRaceResult(3);
        Release.printTheMostMovedCars(carList);
    }


}