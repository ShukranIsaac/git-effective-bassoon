package com.example.gitsocial.domain;

public class User extends IdentifiableObject {
    private long id;
    private String email;
    private String username;
    private String password;

    public User(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.password = builder.password;
        this.username = builder.username;
    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public long id() {
        return id;
    }

    public static class Builder extends IdentifiableObject.Builder<Builder> {
        private String email;
        private String username;
        private String password;
        private long id;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }

        @Override
        public Builder id(long id) {
            this.id = id;
            return this;
        }
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
