package com.danachury.samples.dojojavaoptional.immutables.valueobjects;

import static java.util.Objects.isNull;

public record Url(String value) {

    public Url {
        mayBeAValidUrl(value);
    }

    public static class InvalidUrlException extends RuntimeException {

        private static final String INVALID_URL_ERROR_MSG = "Value: '%s' is not a valid URL";

        public InvalidUrlException(String value) {
            super(String.format(INVALID_URL_ERROR_MSG, value));
        }
    }

    private static void mayBeAValidUrl(String value) {
        if (isNull(value))
            throw new InvalidUrlException("Value must not be null");
    }
}
