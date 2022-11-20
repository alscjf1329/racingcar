import javax.xml.transform.Result;

/**
 * - 사용자에게 전진 시도를 몇 번 할 것인지 입력받는다 o
 * - 시도 횟수는 숫자여야 한다.
 * - 입력이 1이상의 수로 들어와야한다.
 * - 각 자동차별로 전진 여부를 결정한다. o
 * - 전진 여부를 결정하기 위한 랜덤 값을 입력받는다 o
 * - 값은 0 ~ 9 사이의 값이어야한다. o
 * - 값에 따라 자동차를 전진시킨다. o
 * - 값이 4이상이면 전진한다. o
 * - 값이 3이하이면 멈춰있는다. o
 * - 각 시도마다 현재 위치를 보여준다.
 */
public class CarService {
    CarList carList;

    public CarService(CarList carList, int n) {
        if (carList.isError()) {
            return;
        } else if (n >= 1) {
            this.carList = carList;
        }
    }

    public void printRaceResult(int n) {
        Release.printCarNames(carList);
        Release.printCarPositions(carList);
        carListAdcance(n);
    }

    private void carListAdcance(int n) {
        for (int i = 0; i < n; i++) {
            carAdvane();
        }
    }

    private void carAdvane() {
        for (Car c : carList.getCarList()) {
            if (whetherToAdvance()) {
                c.increasePosition();
            }
        }
        Release.printCarAdvanceResult(carList);
    }

    private int randomInt(int start, int end) {
        if (start > end) {
            return -1;
        }
        int interval = end - start;
        return start + (int) (Math.random() * interval) + 1;
    }

    private boolean whetherToAdvance() {
        return (randomInt(0, 9) >= 4) ? true : false;
    }
}
