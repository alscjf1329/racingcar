/**
 * TODO
 * - 자동차 이름을 입력 받아 자동차를 생성 o
 * - 자동차 이름에 공백이 들어오면 안된다. o
 * - 자동차 이름은 1자 ~ 5자 사이여야 한다. o
 * - 자동차 초기 위치는 출발점이어야 한다. o
 */
public class Car {
    private String name;
    private int position = 0;

    public Car(String CarName) {
        if (CarName == null) {
            Release.printCarError(PrintCarErrorMode.NAME_IS_NULL, CarName);
            return;
        }
        if (CarName.length() <= 0) {
            Release.printCarError(PrintCarErrorMode.NAME_LENGTH_IS_ZERO, CarName);
            return;
        }
        if (CarName.length() > 5) {
            Release.printCarError(PrintCarErrorMode.NAME_LENGTH_BIGGER_THAN_FIVE, CarName);
            return;
        }
        if (CarName.contains(" ")) {
            Release.printCarError(PrintCarErrorMode.NAME_CONTAINS_BLANK, CarName);
            return;
        }
        this.name = CarName;

    }

    public String getName() {
        return name;
    }

    public boolean isError() {
        if (name == null) {
            return true;
        }
        if (name.length() <= 0) {
            return true;
        }
        if (name.length() > 5) {
            return true;
        }
        if (name.contains(" ")) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (name == null) {
            return "Can't make car by this name";
        }
        return String.format("%s의 위치: %d", name, position);
    }

    public void increasePosition() {
        this.position += 1;
    }

    public int getPosition() {
        return this.position;
    }
}

enum PrintCarErrorMode {
    NAME_IS_NULL, NAME_LENGTH_IS_ZERO, NAME_LENGTH_BIGGER_THAN_FIVE, NAME_CONTAINS_BLANK
}