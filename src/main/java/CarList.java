import java.util.ArrayList;
import java.util.List;

/**
 * - 1대 이상의 자동차가 존재해야한다. o
 * - 중복된 이름의 자동차가 존재할 수 없다. o
 * - 쉼표의 개수와 자동차 이름의 개수가 맞아야한다. o
 */
public class CarList {
    private List<Car> CarList;
    private int length = 0;
    private boolean errorFlag = true;
    private String input;

    public CarList(String input) {
        this.input = input;
        String[] temp = input.split(",");
        Car newCar;
        CarList = new ArrayList<>();

        for (int i = 0; i < temp.length; i++) {
            if (isOverlapCarName(temp[i])) {
                Release.printCarListError(PrintCarListErrorMode.CAR_NAME_LIST_OVERLAP);
                return;
            }
            newCar = new Car(temp[i]);
            if (newCar.isError()) {
                return;
            }

            this.CarList.add(newCar);
            this.length++;
        }

        if (!isEqualCommaCarCount(input)) {
            Release.printCarListError(PrintCarListErrorMode.COMMA_COUNT_NOT_SAME_CAR_COUNT);
            return;
        }
        return;
    }



    public boolean isError() {
        if (!isEqualCommaCarCount(input)) {
            return true;
        }
        if (CarList == null) {
            return true;
        }
        return false;
    }

    public boolean isOverlapCarName(String s) {
        for (Car c : this.CarList) {
            if (c.getName().equals(s)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEqualCommaCarCount(String s) {
        int commaCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ',') {
                commaCount++;
            }
        }
        return (this.length - 1 == commaCount) ? true : false;

    }

    public List<Car> getCarList() {
        return CarList;
    }

    public void printCarNameList() {
        if (isError()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < CarList.size(); i++) {
            stringBuilder.append(CarList.get(i).toString()).append("\n");
        }
        System.out.print(stringBuilder);
    }
}
enum PrintCarListErrorMode{
    CAR_NAME_LIST_OVERLAP,COMMA_COUNT_NOT_SAME_CAR_COUNT
}
