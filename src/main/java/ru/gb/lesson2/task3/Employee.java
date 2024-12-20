package ru.gb.lesson2.task3;

import ru.gb.lesson2.task3.annotations.Column;
import ru.gb.lesson2.task3.annotations.Entity;
import ru.gb.lesson2.task3.annotations.Table;

import java.util.UUID;

/**
 * @author PetSoft
 * @date 20.12.2024 13:38
 */
@Entity
@Table(name = "users")
public class Employee {
    @Column(name = "id", primaryKey = true)
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    public Employee(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
