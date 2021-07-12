package com.example.gitsocial.domain;

import androidx.annotation.Nullable;

public abstract class Follower extends IdentifiableObject {
    private String login;
    private String id;
    private String node_id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private String site_admin;
    private Boolean deleted;

    public Follower() {}

    public Follower(Builder builder) {
        this.id = builder.id;
        this.deleted = builder.deleted;
        this.type = builder.type;
        this.login = builder.login;
        this.site_admin = builder.site_admin;
        this.node_id = builder.node_id;
        this.avatar_url = builder.avatar_url;
    }

    @Nullable
    @Override
    public String login() {
        return login;
    }

    @Nullable
    @Override
    public String id() {
        return id;
    }

    @Nullable
    @Override
    public String avatar_url() {
        return avatar_url;
    }

    @Nullable
    @Override
    public String node_id() {
        return node_id;
    }

    @Nullable
    @Override
    public String type() {
        return type;
    }

    @Nullable
    @Override
    public String site_admin() {
        return site_admin;
    }

    @Override
    public Boolean deleted() {
        return deleted;
    }

    public static abstract class Builder extends IdentifiableObject.Builder<Builder> {
        private String login;
        private String id;
        private String node_id;
        private String avatar_url;
        private String type;
        private String site_admin;
        private Boolean deleted;

        @Override
        public Builder login(@Nullable String login) {
            this.login = login;
            return this;
        }

        @Override
        public Builder avatar_url(@Nullable String avatar) {
            this.avatar_url = avatar;
            return this;
        }

        @Override
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        @Override
        public Builder node_id(@Nullable String node_id) {
            this.node_id = node_id;
            return this;
        }

        @Override
        public Builder type(@Nullable String type) {
            this.type = type;
            return this;
        }

        @Override
        public Builder site_admin(@Nullable String site_admin) {
            this.site_admin = site_admin;
            return this;
        }

        @Override
        public Builder deleted(Boolean deleted) {
            this.deleted = deleted;
            return this;
        }
    }
}
