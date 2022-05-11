package com.danachury.samples.dojojavaoptional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private Application application;

    @Test
    void contextLoads() {
        assertNotNull(this.application);
    }

    // Optional Helper methods

    @Test
    void shouldCreateAnOptional() {
        // .of()
        // .ofNullable()
        // .empty()
        String nullable = null;
        if (Math.random() > Math.round(.13543))
            nullable = null;
        assertNotNull(Optional.of("This is my string"));
        assertNotNull(Optional.ofNullable(nullable));
        assertNotNull(Optional.empty());
    }

    @Test
    void shouldBeAPresentOptional() {
        assertTrue(Optional.of("This is my string").isPresent());
        assertTrue(Optional.of("NULL").isPresent()); // -> fails?
        assertTrue(Optional.of("null").isPresent()); // -> fails?
        assertTrue(OptionalInt.of(3).isPresent());
        assertTrue(OptionalLong.of(1L).isPresent());
        assertTrue(OptionalDouble.of(1.1).isPresent());
    }

    @Test
    void shouldBeAnEmptyOptional() {
        assertTrue(Optional.of(null).isPresent());
        assertTrue(Optional.ofNullable(null).isEmpty());
        // assertTrue(OptionalInt.of(null).isEmpty()); // -> fails?
        // assertTrue(OptionalLong.of(null).isEmpty()); // -> fails?
        // assertTrue(OptionalDouble.of(null).isEmpty()); // -> fails?
    }

    // Optional Helper Functional methods

    @Test
    void shouldUseFunctionalMethods() {
        final String nullableString;
        if (Math.random() > Math.round(.13543))
            nullableString = null;
        else
            nullableString = "This my string";

        Optional.ofNullable(nullableString)
            .ifPresent(string -> { // ifPresent()
                // If nullable is NOT NULL:
                assertNotNull(nullableString);
                assertEquals("This is my string", string);
            });

        Optional.ofNullable(nullableString)
            .ifPresentOrElse(string -> { // ifPresentOrElse()
                // If nullable is NOT NULL:
                assertNotNull(nullableString);
                assertEquals("This is my string", string);
            }, () -> {
                // If nullable is NULL:
                assertNull(nullableString);
            });

        // Optional functions?
        // map
        // flatMap
        // filter

    }
}
