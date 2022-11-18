import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * - 1대 이상의 자동차가 존재해야한다. o
 * - 중복된 이름의 자동차가 존재할 수 없다. o
 * - 쉼표의 개수와 자동차 이름의 개수가 맞아야한다. o
 */
public class CarList {
    private List<Car> CarNameList;
    private int length = 0;

    public CarList(String input) {
        String[] temp;
        Car newCar;
        temp = input.split(",");
        CarNameList = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            newCar=new Car(temp[i]);
            if(CarNameList.contains(newCar)){
                Reasult.printError("CarNameList overlap");
                return;
            }
            this.CarNameList.add(newCar);
            this.length++;
        }
        if(!isEqualCommaCarCount(input)){
            Reasult.printError("CommaCount != CarCount");
            return;
        } else if (CarNameList.size() == 0) {
            Reasult.printError("CarNameList is empty");
            return;
        }

    }

    private boolean isEqualCommaCarCount(String s) {
        int commaCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ',') {
                commaCount++;
            }
        }
        return (this.length == commaCount) ? true : false;

    }

    public List<Car> getCarNameList() {
        return CarNameList;
    }

    public void printCarNameList() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < CarNameList.size(); i++) {
            bufferedWriter.write(CarNameList.get(i).toString() + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
