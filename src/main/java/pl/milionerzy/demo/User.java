package pl.milionerzy.demo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class User {
    private String userName;
    private String password;

    private int wynik;

    public User(String name, String password) {
        this.userName = name;
        this.password = password;
    }

    public User() {
        this.userName = userName;
        this.password = password;
        this.wynik = wynik;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void aktualizujWynik(int nowyWynik) {
        this.wynik = nowyWynik;
    }

    public void zapiszWynikDoPliku(String userName) {
        Path path = Paths.get("Milionerzy_wynik.txt");
        try {
            if (!Files.exists(path)) {
                try (PrintWriter writer = new PrintWriter(new FileWriter("Milionerzy_wynik.txt"))) {
                    writer.println("Wynik: " + wynik + " " + userName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
                    writer.write("Wynik: " + wynik + " " + userName);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}