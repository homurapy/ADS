package lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        System.out.println(numberInThePowerOf(3, 5));
//        System.out.println(Math.pow(3, 5));
    }

    public static Integer numberInThePowerOf(Integer number, Integer power) {
        if (power == 0) {
            return 1;
        }
        return number * numberInThePowerOf(number, power - 1);
    }



    public Integer calcTotalPrice(List<Item> items) {
        Integer total = 0;
        if (items == null) {
            return total;
        }
        for (Integer integer = 0; integer < items.size(); integer++) {
            total += items.get(integer).getPrice();
        }
        return total;
    }
}

