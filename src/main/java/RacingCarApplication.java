import domain.CarListCreate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public final class RacingCarApplication {
    public static void main(String[] args) throws Exception {
//        System.out.println("Hello " + Arrays.toString(args));

        BufferedReader brForInputName = new BufferedReader(new InputStreamReader(System.in));
        CarListCreate carList = new CarListCreate();
        List<String> carNameList = carList.createList("hi,");

        System.out.println(carNameList);
    }
}

