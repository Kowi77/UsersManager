package kov.develop.utils;

import kov.develop.model.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class UserTestData {

    public static final User USER_1 = new User(1, "Andrey", "Kovalenko", LocalDate.of(1977, 03, 17), "kowi",  "lightpass", "smth info", "Nsk");
    public static final User USER_2 = new User(2, "Yulia", "Kovalenko", LocalDate.of(1980, 07, 24), "iuly",  "StRoNgPaSs", "interesting info", "Berdsk");
    public static final User USER_3 = new User(3, "Zlatan", "Ibragimovich", LocalDate.of(1950, 01, 01), "zlatan",  "no_pass", "MU", "Sweden");

    public static final List<User> USERS = Arrays.asList(USER_1, USER_2, USER_3);

    public static User getCreated() { return new User(null, "NoName", "Dontnow", LocalDate.of(1930, 02, 02), "smth",  "qwerty", "test", "8080");}
    public static User getUpdated() { return new User(1, "Andrey", "Kovalenko", LocalDate.of(1977, 03, 17), "kowi",  "lightpass", "another info", "Nsk");}
}
