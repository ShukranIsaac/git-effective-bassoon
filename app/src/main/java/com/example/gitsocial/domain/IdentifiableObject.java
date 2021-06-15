package com.example.gitsocial.domain;

public abstract class IdentifiableObject {
    public abstract long id();

    public static abstract class Builder<T> {
        public abstract T id(long id);
    }
}
