package com.e16.training.builder;

public class Letter {
    private final String from;
    private final String to;
    private final String message;
    private final String subject;

    private Letter(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.message = builder.message;
        this.subject = builder.subject;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getMessage() {
        return message;
    }

    public String getSubject() {
        return subject;
    }

    public static class Builder {
        private final String from;
        private final String to;
        private String message;
        private String subject;


        public Builder(final String from, final String to) {
            if (from == null || to == null) {
                throw new IllegalStateException("Required field: from, to");
            }

            this.from = from;
            this.to = to;
        }

        public Builder withMessage(final String message) {
            this.message = message;
            return this;
        }

        public Builder withSubject(final String subject) {
            this.subject = subject;
            return this;
        }

        public Letter build() {
            return new Letter(this);
        }

    }
}
