import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CarListCreate{

    public List<String> createList(String inputNameString) {
        List<String> carNameList = List.of(inputNameString.split(","));
        for (String carName : carNameList){
            if (carName.contains(" ")){
                System.out.println("자동차 이름 중 공백이 포함되어 있습니다.");
            }
            if (carName.length()>5 || carName.length()<1){
                System.out.println("자동차 이름 길이가 너무 길거나 짧습니다.");
            }
            // TODO : 중복된 자동차 이름 찾기, 쉼표의 개수와 자동차 이름의 개수가 맞아야한다.
        }

        return carNameList;
    }
}