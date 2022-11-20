import java.util.ArrayList;
import java.util.List;

public class Release {
    private static final int allocationSize = 7;

    public static void printError(String mode, String CarName) {

        switch (mode) {
            case "1": {
                toString(CarName + ": No spaces in the Car name");
                break;
            }
            case "2": {
                toString(CarName + ": Car name is too short to make car");
                break;
            }
            case "3": {
                toString(CarName + ": Car name is too long to make car");
                break;
            }
        }
    }

    public static void printError(String mode) {
        switch (mode) {
            case "CommaCount != CarCount": {
                toString("Comma count is not equal Car count");
                break;
            }
            case "CarNameList overlap": {
                toString("CarName is overlap");
                break;
            }
            case "CarNameList is empty": {
                toString("CarNameList is empty");
                break;
            }

        }

    }

    public static void printCarNames(CarList list) {
        if (list.isError()) {
            return;
        }
        for (Car c : list.getCarList()) {
            System.out.printf("%" + allocationSize + "s", c.getName());
        }
        System.out.println();
    }

    public static void printCarAdvanceResult(CarList list) {
        if (list.isError()) {
            return;
        }
        printCarPositions(list);

    }

    public static void printCarPositions(CarList list) {
        for (Car c : list.getCarList()) {
            System.out.printf("%" + allocationSize + "d", c.getPosition());
        }
        System.out.println();
    }

    public static void printTheMostMovedCars(CarList list) {
        int maxPosition = theBiggestCarPosition(list);
        List<Car> winnerList = new ArrayList<>();

        for (Car c : list.getCarList()) {
            if (c.getPosition() == maxPosition) {
                winnerList.add(c);
            }
        }
        for(int i=0; i<winnerList.size(); i++){
            System.out.print(winnerList.get(i).getName());
            if(i<winnerList.size()-1) System.out.print(",");;
        }
    }

    private static int theBiggestCarPosition(CarList list) {
        int maxPosition = 0;
        for (Car c : list.getCarList()) {
            maxPosition = (c.getPosition() > maxPosition) ? c.getPosition() : maxPosition;
        }
        return maxPosition;
    }

    private static String toString(String s) {
        System.out.println(s);
        return s;
    }
}