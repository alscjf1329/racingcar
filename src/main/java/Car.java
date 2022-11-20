import java.util.Set;

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
    private boolean ErrorFlag = true;

    public Car(String CarName) {
        if (CarName.length() <= 0) {
            Release.printError("2", CarName);
            return;
        } else if (CarName.length() > 5) {
            Release.printError("3", CarName);
            return;
        } else if (CarName.contains(" ")) {
            Release.printError("1", CarName);
            return;
        } else {
            ErrorFlag = false;
            this.name = CarName;
        }

    }

    public String getName() {
        return name;
    }

    public boolean isError() {
        return ErrorFlag;
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