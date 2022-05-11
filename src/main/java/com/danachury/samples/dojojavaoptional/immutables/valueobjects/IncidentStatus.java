package com.danachury.samples.dojojavaoptional.immutables.valueobjects;

public enum IncidentStatus {
    NEW,
    OPEN,
    CLOSED,
    ON_HOLD,
    RESOLVED,
    MONITORING;

    public static IncidentStatus from(String value) {
        try {
            return valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidIncidentStatusException(value);
        }
    }

    public static class InvalidIncidentStatusException extends RuntimeException {

        public InvalidIncidentStatusException(String status) {
            super(String.format("status: '%s' is not a valid entry", status));
        }
    }
}
