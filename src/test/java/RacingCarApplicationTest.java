import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarApplicationTest {
    @Test
    void 테스트() throws IOException {
        String[] strings = {"안녕", "친구들", ""};
        RacingCarApplication.main(strings);
    }
}