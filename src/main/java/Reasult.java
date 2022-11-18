public class Reasult {
    public static void printError(String mode, String CarName) {
        StringBuffer stringBuffer = new StringBuffer();
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
        System.out.println(stringBuffer);
    }

    public static void printError(String mode) {
        StringBuffer stringBuffer = new StringBuffer();
        switch (mode) {
            case "CommaCount != CarCount": {
                toString("Comma count is not equal Car count");
                break;
            }
            case "CarNameList overlap": {
                toString("CarNameList contains newCar");
                break;
            } case "CarNameList is empty":{
                toString("CarNameList is empty");
                break;
            }

        }
        System.out.println(stringBuffer);
    }

    private static String toString(String s) {
        System.out.println(s);
        return s;
    }
}