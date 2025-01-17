package ru.job4j.lambda;

import java.util.function.IntSupplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            int totalForLambda = total;
            total = add(
                    () -> totalForLambda + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(IntSupplier calc) {
        return calc.getAsInt();
    }
}