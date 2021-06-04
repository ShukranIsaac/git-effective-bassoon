package com.example.gitsocial.entities;

import androidx.annotation.Nullable;

public abstract class IdentifiableObject extends BaseObject {
    private String login;
    private String id;
    private String node_id;
    private String type;
    private String site_admin;

    @Nullable
    public abstract String login();

    @Nullable
    public abstract String id();

    @Nullable
    public abstract String node_id();

    @Nullable
    public abstract String type();

    @Nullable
    public abstract String site_admin();

    public static abstract class Builder<T extends Builder> {

        public abstract T id(String id);

        public abstract T login(@Nullable String login);

        public abstract T node_id(@Nullable String node_id);

        public abstract T type(@Nullable String type);

        public abstract T site_admin(@Nullable String site_admin);

        public abstract T deleted(Boolean deleted);
    }
}
