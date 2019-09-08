package ru.job4j.bank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Банковские переводы.
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 06.09.2019
 */
class Bank {
    /**
     * База данных, которая включает в себя клиентов и их учетные записи.
     */
    private Map<User, List<Account>> bank = new HashMap<>();
    /**
     * Метод добавления клиента в базу.
     * @param user - клиент.
     */
    void addUser(User user) {
        this.bank.putIfAbsent(user, new ArrayList<>());
    }
    /**
     * Метод удаления клиента из базы.
     * @param user - клиент.
     * @return возвращает true если клиент удален из базы, иначе false
     */
    boolean deleteUser(User user) {
        return null != this.bank.remove(user);
    }
    /**
     * Метод поиска клиента по Id
     * @param passport - паспорт клиента
     * @return клиент
     */
     User getUserById(String passport) {
        User result = null;
        for (User user : this.bank.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }
    /**
     *  Метод добавляет счёт пользователю.
     *  @param passport - паспорт клиента.
     *  @param account - счет клиента.
     */
     void addAccountToUser(String passport, Account account) {
         List<Account> accounts = this.bank.get(this.getUserById(passport));
         accounts.add(account);
    }
    /**
     * Метод удаляет один счёт пользователя.
     * @param passport - паспорт клиента.
     * @param account - счет клиента.
     */
    void deleteAccountFromUser(String passport, Account account) {
        List<Account> accounts = this.bank.get(this.getUserById(passport));
        for (Account value : accounts) {
            if (value.equals(account)) {
                accounts.remove(value);
            }
        }
    }
    /**
     * Метод возвращает счет клиента, найденный по реквизитам.
     * @param passport - паспорт клиента.
     * @param requisites - реквизиты счета клиента.
     * @return Account пользователя.
     */
    private Account getUserOneAccount(String passport, String requisites) {
        Account userAccount = null;
        List<Account> userAccounts = this.getUserAccounts(passport);
        for (Account account : userAccounts) {
            if (account.getRequisites().equals(requisites)) {
                userAccount = account;
            }
        }
        return userAccount;
    }
    /**
     * Метод позволяет получить список счетов для пользователя.
     * @param passport - паспорт клиента
     * @return  - список счетов клиентов.
     */
    List<Account> getUserAccounts(String passport) {
        return this.bank.get(this.getUserById(passport));
    }
    /**
     * Перевод суммы с одного счета на другой.
     * @param srcPassport Номер паспорта пользователя, со счета которого будет перевод.
     * @param srcRequisite Реквизиты счета, с которого будет перевод.
     * @param destPassport Номер паспорта пользователя, на счет которого будет перевод.
     * @param destRequisite Реквизиты счета, на который будет перевод.
     * @param amount Сумма перевода.
     * @return true, если перевод успешен.
     */
    boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite,
                                 double amount) {
        boolean result = false;
        Account src = this.getUserOneAccount(srcPassport, srcRequisite);
        Account dest = this.getUserOneAccount(destPassport, destRequisite);
        if (src != null && dest != null && src.getMoney() > amount) {
            src.deductMoney(amount);
            dest.addMoney(amount);
            result = true;
        }
        return result;
    }
}