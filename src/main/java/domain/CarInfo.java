package domain;

import infrastructure.Rand;

public class CarInfo {
    String carName;
    int nowLocation;

    public CarInfo() {

    }

    public int go(int nowLocation) { // 전진 여부를 결정하기 위해 랜덤 값을 받는다.
        // 값에 따라 전진한다.


        nowLocation = +nowLocation + Rand.r(0, 9);
        return nowLocation;
    }


}
