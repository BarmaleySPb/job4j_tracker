package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertEquals(bank.findByPassport("3434").orElseThrow(), user);
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertEquals(bank.findByRequisite("34", "5546"), Optional.empty());
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertEquals((Double) bank.findByRequisite("3434", "5546").orElseThrow().getBalance(),
                (Double) 150D);
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("123", 100D));
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertFalse(bank.transferMoney(user.getPassport(), "123", user.getPassport(), "5546",
                500D));
        assertFalse(bank.transferMoney(user.getPassport(), "12345", user.getPassport(), "5546",
                500D));
        assertEquals(200D,
                bank.findByRequisite(user.getPassport(), "113").orElseThrow().getBalance(), 0);
        assertEquals(0D,
                bank.findByRequisite(user.getPassport(), "5546").orElseThrow().getBalance(), 0);

    }

    @Test
    public void findByRequisite() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        Account accountFirst = new Account("5546", 150D);
        Account accountSecond = new Account("5547", 10D);
        bank.addUser(user);
        bank.addAccount(user.getPassport(), accountFirst);
        bank.addAccount(user.getPassport(), accountSecond);
        assertEquals(accountFirst, bank.findByRequisite("3434", "5546").orElseThrow());
        assertEquals(accountSecond, bank.findByRequisite("3434", "5547").orElseThrow());
        assertEquals(Optional.empty(), bank.findByRequisite("3434", "1111"));
    }
}