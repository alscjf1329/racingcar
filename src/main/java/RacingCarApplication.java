import java.io.IOException;

public final class RacingCarApplication {

    public static void main(String[] args) throws IOException {
        CarList carList=new CarList(args[0]);
        System.out.println(carList);
    }
}

