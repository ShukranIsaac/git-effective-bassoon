package com.example.gitsocial.entities;

public class User extends Follower {
    private Plan mPlan;

    public User() { }

    public User(Builder builder) {
        this.mPlan = builder.mPlan;
    }

    public static Builder builder() {
        return (Builder) new Builder().deleted(false);
    }

    public Plan plan() {
        return mPlan;
    }

    public static class Builder extends Follower.Builder {
        private Plan mPlan;

        public Builder plan(Plan plan) {
            this.mPlan = plan;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
