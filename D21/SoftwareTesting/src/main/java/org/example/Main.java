package org.example;

import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }



    public int tinh(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }






    public String thanhToan(PaymentClient paymentClient) {
        int result = paymentClient.processTransaction();
        if (result > 0) {
            return "Thanh Toan Thanh Cong " + result;
        } else if (result == 0) {
            return "Khong chuyen tien duoc";
        } else {
            return "Thanh Toan That Bai";
        }
    }




    public String getTwoTopScore(List<Student> list) {
        if (list == null || list.size() == 0 ) {
            return "Khong co hoc sinh nao";
        }
        list.sort((o1, o2) -> o2.getScore() - o1.getScore());
        if (list.get(0).getName() == list.get(1).getName()) {
            return "Hai hoc sinh co cung diem";
        }
        return list.get(0).getName() + " " + list.get(1).getName();
    }


}