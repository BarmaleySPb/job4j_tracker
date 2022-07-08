package ru.job4j.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = List.of(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                List.of(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertEquals(expect, NotifyAccount.sent(accounts));
    }

    @Test
    public void sentWithDuplicate() {
        List<Account> accounts = List.of(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001"),
                new Account("333", "Vasiliy Vasin", "4564bnmb"),
                new Account("333", "Vasiliy Vasin", "456yuy5646")
        );
        HashSet<Account> expect = new HashSet<>(
                List.of(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001"),
                        new Account("333", "Vasiliy Vasin", "4564bnmb")
                )
        );
        assertEquals(expect, NotifyAccount.sent(accounts));
    }
}