import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public final class RacingCarApplication {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello " + Arrays.toString(args));
        //d
        BufferedReader brForInputName = new BufferedReader(new InputStreamReader(System.in));
        CarListCreate carlist = new CarListCreate();
        List<String> carNameList = carlist.createList(brForInputName.readLine());
        System.out.println(carNameList);
    }
}

