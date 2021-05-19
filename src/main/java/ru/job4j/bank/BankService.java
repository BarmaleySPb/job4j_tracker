package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * класс описывает работу простейшего банковкого сервиса
 *
 * @author Zakharov Evgeny
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных сервиса осуществляется в карте Map, в качестве ключа используем User
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод принимает на вход модель User, при отсутствии в списке клиентов,
     * создает нового с дефолтным списком счетов.
     *
     * @param user модель клиета, содержит номер паспорта и список счетов
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * метод принимает пасспорт и счет клиента, при нахождении в списке клиентов,
     * проверяет наличие счета, при его отсутствии добавляет в список счетов.
     *
     * @param passport номер паспорта клиента.
     * @param account  счет, который добавляется к списку счетов
     */
    public void addAccount(String passport, Account account) {
        User findUser = findByPassport(passport);
        if (findUser != null) {
            List<Account> accounts = users.get(findUser);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * метод осуществляет поиск клиента по номеру паспорта
     *
     * @param passport номер пасспрта по которому осуществляется поиск клиента
     * @return возвращает клиента, если клиент не найден возвращает null.
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * метод осуществляет поиск счета по реквизитам
     *
     * @param passport  номер паспорта клиента для проверки
     * @param requisite реквизиты счета
     * @return возвращает счет клиента, если счет не найден возвращает null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User findUser = findByPassport(passport);
        if (findUser != null) {
            return users.get(findUser).stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * метод осуществляет денежный перевод со счета клиента на другой счет
     *
     * @param srcPassport   паспорт клиента отправителя
     * @param srcRequisite  реквизиты счета отправителя
     * @param destPassport  паспорт получателя перевода
     * @param destRequisite реквизиты счета получателя
     * @param amount        сумма перевода
     * @return возвращает true в случае успешного перевода, либо null в случае
     * если перевод не был осуществлен.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account source = findByRequisite(srcPassport, srcRequisite);
        Account destination = findByRequisite(destPassport, destRequisite);
        if (source != null && destination != null && source.getBalance() >= amount) {
            source.setBalance(source.getBalance() - amount);
            destination.setBalance(destination.getBalance() + amount);
            return true;
        }

        return false;
    }
}