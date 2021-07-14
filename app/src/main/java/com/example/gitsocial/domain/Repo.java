package com.example.gitsocial.domain;

public class Repo extends BaseObject {
    private final Owner mOwner;

    public Repo(Builder builder) {
        this.mOwner = builder.mOwner;
    }

    public Owner owner() {
        return mOwner;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public Boolean deleted() {
        return null;
    }

    public static class Builder {
        private Owner mOwner;

        public Repo build() {
            return new Repo(this);
        }

        public Builder owner(Owner owner) {
            this.mOwner = owner;
            return this;
        }
    }

}
