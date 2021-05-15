package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Functions {

    public static List<Double> diapason(int start, int finish, Function<Double, Double> func) {

        List<Double> res = new ArrayList<>();
        for (int i = start; i <= finish; i++) {
            res.add(func.apply((double) i));
        }
        return res;
    }
}
