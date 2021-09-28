package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertEquals(office.get(citizen.getPassport()), citizen);
    }

    @Test
    public void addSamePassport() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenWithSamePassport = new Citizen("2f44a", "Vasya Vasin");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertFalse(office.add(citizenWithSamePassport));
        assertEquals(office.get(citizen.getPassport()), citizen);
    }
}