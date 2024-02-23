import org.example.Main;
import org.example.PaymentClient;
import org.example.Student;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestClass {

    @Mock
    PaymentClient paymentClient;


    @Test
    public void test_01_add_number_correctly() {
        Main main = new Main();
        Assertions.assertEquals(30, main.tinh("10", "20"));
    }

    @Test
    public void test_02_enter_number_incorrectly() {
        Main main = new Main();
        Exception e = Assertions.assertThrows(NumberFormatException.class, () -> main.tinh("a", "b"));
        Assertions.assertEquals("Khong hop le", e.getMessage());
    }



    @Test
    public void test_02_when_payment_success_should_return_success() {
        Mockito.when(paymentClient.processTransaction()).thenReturn(400);
        Main main = new Main();
        Assertions.assertEquals(main.thanhToan(paymentClient), "Thanh Toan Thanh Cong 50");
    }

    @Test
    public void test_03_when_payment_fail_should_return_fail() {
        Mockito.when(paymentClient.processTransaction()).thenReturn(-5);
        Main main = new Main();
        Assertions.assertEquals(main.thanhToan(paymentClient), "Thanh Toan That Bai");
    }

    @Test
    public void test_04_payment_if_amount_is_zero_then_not_transaction() {
        Mockito.when(paymentClient.processTransaction()).thenReturn(0);
        Main main = new Main();
        Assertions.assertEquals(main.thanhToan(paymentClient), "Khong chuyen tien duoc");
    }




    @Test
    public void test_05_return_correct_two_top_score() {
        Student student = new Student("Nam", 50);
        Student student1 = new Student("Tuan", 60);
        Student student2 = new Student("Huy", 70);
        List<Student> list = new java.util.ArrayList<>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        Main main = new Main();
        Assertions.assertEquals("Huy Tuan", main.getTwoTopScore(list));
    }

    @Test
    public void test_06_if_there_is_no_student_should_notify() {
        List<Student> list = new java.util.ArrayList<>();
        Main main = new Main();
        Assertions.assertEquals("Khong co hoc sinh nao", main.getTwoTopScore(list));
    }

    @Test
    public void test_07_if_there_is_same_score_should_notify() {
        Student student = new Student("Nam", 50);
        Student student1 = new Student("Tuan", 50);
        List<Student> list = new java.util.ArrayList<>();
        list.add(student);
        list.add(student1);
        Main main = new Main();
        Assertions.assertEquals("Hai hoc sinh co cung diem", main.getTwoTopScore(list));
    }



}
