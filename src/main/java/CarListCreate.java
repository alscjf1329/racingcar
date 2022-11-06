import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CarListCreate {

    public List<String> createList(String inputNameString) {

        List<String> carNameList = List.of(inputNameString.split(","));
        Set<String> carNameCount = new HashSet<>();
        //오류 방출
        for (String carName : carNameList) {

            if (carName.contains(" ")) {
                System.out.println("자동차 이름 중 공백이 포함되어 있습니다.");
            }
            if (carName.length() > 5 || carName.length() < 1) {
                System.out.println("자동차 이름 길이가 너무 길거나 짧습니다.");
            }
            if (carNameCount.contains(carName)) {
                System.out.println("중복된 자동차 있음");
            }
            if (!isEqual_restDotCount_carCount(inputNameString, carNameList.size())) {
                System.out.println("쉼표 개수와 자동차 개수가 맞지 않음");
            }
            // TODO : 중복된 자동차 이름 찾기, 쉼표의 개수+1와 자동차 이름의 개수가 맞아야한다.
        }

        return carNameList;
    }

    private boolean isEqual_restDotCount_carCount(String inputS, int carCount) {

        int restDotCount = 0;
        for (int i = 0; i < inputS.length(); i++) {
            if (inputS.charAt(i) == ',') {
                restDotCount++;
                if (restDotCount > carCount) {
                    return false;
                }
            }
        }
        if (restDotCount + 1 == carCount) {
            return true;
        } else {
            return false;
        }

    }
}