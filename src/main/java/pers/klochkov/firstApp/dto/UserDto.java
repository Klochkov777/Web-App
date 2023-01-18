package pers.klochkov.firstApp.dto;

import java.util.Objects;

public class UserDto {
    public String login;
    public String name;

    public UserDto(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(login, userDto.login) && Objects.equals(name, userDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name);
    }
}
