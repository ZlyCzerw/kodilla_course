package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public class ForumUser {
    private final int uniqeId;
    private final String userName;
    private final char sex;
    private final LocalDate birthDate;
    private final int postNo;

    public ForumUser(int uniqeId, String userName, char sex, LocalDate birthDate, int postNo) {
        this.uniqeId = uniqeId;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postNo = postNo;
    }

    public int getUniqeId() {
        return uniqeId;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public int getPostNo() {
        return postNo;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return uniqeId == forumUser.uniqeId &&
                sex == forumUser.sex &&
                postNo == forumUser.postNo &&
                Objects.equals(userName, forumUser.userName) &&
                Objects.equals(birthDate, forumUser.birthDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uniqeId, userName, sex, birthDate, postNo);
    }

    @Override
    public String toString() {
        return "ForumUser: " +

                "userName='" + userName + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postNo=" + postNo +
                '}';
    }
}
