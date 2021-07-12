package com.example.gitsocial.domain;

public class Tutorial extends BaseObject {
    private String thumbnail;
    private String title;
    private Boolean deleted;

    public Tutorial() { }

    public Tutorial(Builder builder) {
        this.thumbnail = builder.thumbnail;
        this.title = builder.title;
        this.deleted = builder.deleted;
    }

    public String thumbnail() {
        return thumbnail;
    }

    public String title() {
        return title;
    }

    @Override
    public Boolean deleted() {
        return deleted;
    }

    public Builder toBuilder() {
        return builder()
                .deleted(deleted)
                .title(title)
                .thumbnail(thumbnail);
    }

    public static Builder builder() {
        return new Builder().deleted(false);
    }

    public static class Builder {
        private String thumbnail;
        private String title;
        private Boolean deleted;

        public Builder thumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder deleted(Boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public Tutorial build() {
            return new Tutorial(this);
        }
    }
}
