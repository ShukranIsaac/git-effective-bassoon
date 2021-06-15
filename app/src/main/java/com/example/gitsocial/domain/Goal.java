package com.example.gitsocial.domain;

import java.util.Date;

public class Goal extends IdentifiableObject {
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private long id;

    public Goal(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public Goal(String title, String description, Date startDate, Date endDate) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Goal(long id, String title, String description, Date startDate, Date endDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends IdentifiableObject.Builder<Builder> {
        private String title;
        private String description;
        private Date startDate;
        private Date endDate;
        private long id;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder startDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        @Override
        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Goal build() {
            return new Goal(this);
        }
    }

    @Override
    public long id() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public long getId() {
        return id;
    }
}
