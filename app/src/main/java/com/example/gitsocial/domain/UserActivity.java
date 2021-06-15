package com.example.gitsocial.domain;

import java.util.Date;

public class UserActivity extends Goal {
    private String type;

    public UserActivity(Builder builder) {
        super(builder);
        this.type = builder.type;
    }

    public UserActivity(String title, String description, Date startDate, Date endDate, String type) {
        super(title, description, startDate, endDate);
        this.type = type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Goal.Builder {
        private String type;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public UserActivity build() {
            return new UserActivity(this);
        }
    }

    public String getType() {
        return type;
    }
}
