package com.example.gitsocial.entities;

public class Computer extends BaseObject {
    private String model;
    private String manufacturer;
    private String type;
    private Boolean deleted;
    // more properties

    public Computer(Builder builder) {
        this.model = builder.model;
        this.deleted = builder.deleted;
        this.manufacturer = builder.manufacturer;
        this.type = builder.type;
    }

    public static Builder builder() {
        return new Builder().deleted(false);
    }

    @Override
    public Boolean deleted() {
        return deleted;
    }

    public static class Builder {
        private String model;
        private String manufacturer;
        private String type;
        private Boolean deleted;

        public Builder() { }

        public Builder deleted(Boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public String manufacturer() {
        return manufacturer;
    }

    public String type() {
        return type;
    }

    public String model() {
        return model;
    }
}
