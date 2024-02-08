package org.example.domain.entity;

public class User {
    private int id;
    private String firstname, lastname, email, phone_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


    private User(User.Builder builder) {
        this.setId(builder.id);
        this.setFirstname(builder.firstname);
        this.setLastname(builder.lastname);
        this.setEmail(builder.email);
        this.setPhone_number(builder.phone_number);
    }

    public static class Builder {
        private int id;
        private String firstname;
        private String lastname;
        private String email;
        private String phone_number;

        public User.Builder id(int id) {
            this.id = id;
            return this;
        }

        public User.Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public User.Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }
        public User.Builder email(String email) {
            this.email = email;
            return this;
        }
        public User.Builder phone_number(String phone_number) {
            this.phone_number = phone_number;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
