package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertEquals(map.get("3sfe"), new Order("3sfe", "Dress"));
    }

    @Test
    public void whenSameOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("4sfe", "Shirt"));
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("4sfe", "Shirt"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertEquals(map.size(), 2);
    }
}