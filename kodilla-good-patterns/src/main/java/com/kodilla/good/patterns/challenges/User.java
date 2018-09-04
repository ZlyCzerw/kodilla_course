package com.kodilla.good.patterns.challenges;


import java.util.Objects;

public class User {

private String name;
private String address;
private String eMail;

    public User(String name, String address, String eMail) {
        this.name = name;
        this.address = address;
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String geteMail() {
        return eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(address, user.address) &&
                Objects.equals(eMail, user.eMail);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, address, eMail);
    }
}
