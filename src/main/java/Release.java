import java.util.ArrayList;
import java.util.List;

public class Release {
    private static final int allocationSize = 7;

    public static void printCarError(PrintCarErrorMode mode, String CarName) {

        switch (mode) {
            case NAME_CONTAINS_BLANK: {
                toString(CarName + ": No spaces in the Car name");
                break;
            }
            case NAME_LENGTH_IS_ZERO: {
                toString(CarName + ": Car name is too short to make car");
                break;
            }
            case NAME_LENGTH_BIGGER_THAN_FIVE: {
                toString(CarName + ": Car name is too long to make car");
                break;
            }
            case NAME_IS_NULL: {
                toString(CarName + ": Car name is null");
                break;
            }
        }
    }

    public static void printCarListError(PrintCarListErrorMode mode) {
        switch (mode) {
            case COMMA_COUNT_NOT_SAME_CAR_COUNT: {
                toString("Comma count is not equal Car count");
                break;
            }
            case CAR_NAME_LIST_OVERLAP: {
                toString("CarName is overlap");
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
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i).getName());
            if (i < winnerList.size() - 1) System.out.print(",");
            ;
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