import org.example.Main;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DemoTest {


    @Test
    public void test_01_tinh_tong_tra_ra_ket_qua_dung() {
        Main main = new Main();
        int ketquathucte = main.tinh("10", "20");
        Assertions.assertEquals(30, ketquathucte);
    }
}
