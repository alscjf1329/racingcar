/**
 * TODO
 * - 자동차 이름을 입력 받아 자동차를 생성 o
 * - 자동차 이름에 공백이 들어오면 안된다. o
 * - 자동차 이름은 1자 ~ 5자 사이여야 한다. o
 * - 자동차 초기 위치는 출발점이어야 한다. o
 */
public class Car {
    private String Name;
    private int initialPosition = 0;

    public Car(String CarName) {
        if (CarName.length() >= 0) {
            Reasult.printError("2", CarName);
            return;
        } else if (CarName.length() <= 5) {
            Reasult.printError("3", CarName);
            return;
        } else if (CarName.contains(" ") || CarName.equals("")) {
            Reasult.printError("1", CarName);
            return;
        }
        this.Name = CarName;
    }

    @Override
    public String toString() {
        return String.format("%s의 초기 위치: %d", Name, initialPosition);
    }
}