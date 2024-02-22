package pl.milionerzy.demo;

import java.util.HashMap;
import java.util.Map;

public class LoginService {
    private Map<String, User> users;
    private Map<String, Administrator> administrators;


    public LoginService() {
        this.users = new HashMap<>();
        this.administrators = new HashMap<>();

        inicjalizujUzytkownikow();
        inicjalizacjaAdministratorow();

    }

    private void inicjalizacjaAdministratorow() {
        administrators.put("administrotor1", new Administrator("administrator1", "password1"));
        administrators.put("administrotor2", new Administrator("administrator2", "password2"));
    }

    private void inicjalizujUzytkownikow() {
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));


    }

    public boolean zalogujUzytkownika(String userName, String password) {
        User user = users.get(userName);
        return user != null && user.getPassword().equals(password);
    }

    public boolean zalogujAdministratora(String userName, String password) {
        Administrator administrator = administrators.get(userName);
        return administrator != null && administrator.getPassword().equals(password);
    }
}
