package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1.0
 * @since 07.09.2019
 */
public class BankTest {
    /**
     * Создаем объект Банк.
     */
    private Bank bank = new Bank();
    /**
     * Тест добавления клиента
     */
    @Test
    public void whenAddUser() {
        User user = new User("Sergey", "7814");
        this.bank.addUser(user);
        String result = this.bank.getUserById("7814").getName();
        assertThat(result, is("Sergey"));
    }
    /**
     * Тест удаления клиента
     */
    @Test
    public void whenDeleteUser() {
        User user = new User("Sergey", "7814");
        this.bank.addUser(user);
        boolean result = bank.deleteUser(new User("Sergey", "7814"));
        assertThat(result, is(true));
    }
    /**
     * Тест поиска клиента по Id.
     */
    @Test
    public void whenGetIdUser() {
        User user = new User("Andrey", "7816");
        this.bank.addUser(user);
        User result = this.bank.getUserById("7816");
        assertThat(result, is(user));
    }

    /**
     * Добавление счета пользователю.
     */
    @Test
    public void addAccountToUserTest() {
        this.bank.addUser(new User("Nikolai", "7812"));
        Account account1 = new Account(3000.00, "1234_5678_9000");
        Account account2 = new Account(2000.00, "2222_3333_4444");
        List<Account> expected = new ArrayList<>();
        expected.add(account1);
        expected.add(account2);
        this.bank.addAccountToUser("7812", account1);
        this.bank.addAccountToUser("7812", account2);
        List<Account> result = bank.getUserAccounts("7812");
        assertThat(result, is(expected));
    }
    /**
     * Удаление счета у пользователя.
     */
    @Test
    public void deleteAccountFromUserTest() {
        this.bank.addUser(new User("Nikolai", "7812"));
        Account account1 = new Account(3000.00, "1234_5678_9000");
        Account account2 = new Account(2000.00, "2222_3333_4444");
        List<Account> expected = new ArrayList<>();
        expected.add(account2);
        this.bank.addAccountToUser("7812", account1);
        this.bank.addAccountToUser("7812", account2);
        this.bank.deleteAccountFromUser("7812", account1);
        List<Account> result = this.bank.getUserAccounts("7812");
        assertThat(result, is(expected));
    }
    /**
     * Выдача списка всех счетов пользователя.
     */
    @Test
    public void getUserAccountsTest() {
        this.bank.addUser(new User("Dmitri", "7811"));
        Account account1 = new Account(3000.00, "1234_5678_9000");
        Account account2 = new Account(2000.00, "4455_6677_8899");
        Account account3 = new Account(5000.00, "1111_2222_3333");
        List<Account> expected = new ArrayList<>();
        expected.add(account1);
        expected.add(account2);
        expected.add(account3);
        this.bank.addAccountToUser("7811", account1);
        this.bank.addAccountToUser("7811", account2);
        this.bank.addAccountToUser("7811", account3);
        List<Account> result = bank.getUserAccounts("7811");
        assertThat(result, is(expected));
    }

    /**
     * Успешный перевод с одного счета на другой.
     */
    @Test
    public void transferMoneyTestOK() {
        User user1 = new User("Sergey", "7814");
        User user2 = new User("Andrey", "7819");
        this.bank.addUser(user1);
        this.bank.addUser(user2);
        Account accountUser1 = new Account(5000.00, "1234_5678_9000");
        Account accountUser2 = new Account(0.00, "4455_6677_8899");
        this.bank.addAccountToUser("7814", accountUser1);
        this.bank.addAccountToUser("7819", accountUser2);
        this.bank.transferMoney(
                user1.getPassport(), accountUser1.getRequisites(),
                user2.getPassport(), accountUser2.getRequisites(), 1000.00);
        assertThat(accountUser2.getMoney(), is(1000.00));
    }


    @Test
    public void whenOneUserThenTransferMoneyToDifferentAccount() {
        User user = new User("Sergey", "7814");
        this.bank.addUser(user);
        Account account1 = new Account(2000.00, "1131_2471_8365");
        Account account2 = new Account(0.00, "7777_5555_1212");
        this.bank.addAccountToUser("7814", account1);
        this.bank.addAccountToUser("7814", account2);
        this.bank.transferMoney(
                user.getPassport(), account1.getRequisites(),
                user.getPassport(), account2.getRequisites(), 1000.00);
        assertThat(account2.getMoney(), is(1000.00));
    }
}
