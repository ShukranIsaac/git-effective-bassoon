package com.example.gitsocial.domain;

public class Owner extends Follower {
    public Owner(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Follower.Builder {
        public Owner build() {
            return new Owner(this);
        }
    }
}