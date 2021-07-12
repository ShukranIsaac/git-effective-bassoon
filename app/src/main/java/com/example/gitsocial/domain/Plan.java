package com.example.gitsocial.domain;

public class Plan extends BaseObject {
    private String name;
    private String space;
    private String collaborators;
    private String private_repos;
    private Boolean deleted;

    public Plan() { }

    public Plan(Builder builder) {
        this.deleted = builder.deleted;
        this.name = builder.name;
        this.space = builder.space;
        this.collaborators = builder.collaborators;
        this.private_repos = builder.private_repos;
    }

    public String name() {
        return name;
    }

    public String space() {
        return space;
    }

    public String collaborators() {
        return collaborators;
    }

    public String private_repos() {
        return private_repos;
    }

    @Override
    public Boolean deleted() {
        return deleted;
    }

    public static Builder builder() {
        return new Builder().deleted(false);
    }

    public static class Builder {
        private String name;
        private String space;
        private String collaborators;
        private String private_repos;
        private Boolean deleted;

        public Plan build() {
            return new Plan(this);
        }

        public Builder deleted(Boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder space(String space) {
            this.space = space;
            return this;
        }

        public Builder collaborators(String collaborators) {
            this.collaborators = collaborators;
            return this;
        }

        public Builder private_repos(String private_repos) {
            this.private_repos = private_repos;
            return this;
        }
    }
}
