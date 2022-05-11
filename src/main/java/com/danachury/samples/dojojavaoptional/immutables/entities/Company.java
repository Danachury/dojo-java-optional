package com.danachury.samples.dojojavaoptional.immutables.entities;

import org.immutables.value.Value;

import java.util.Optional;
import java.util.TimeZone;

@Value.Immutable
public interface Company {

    String publicId();

    String name();

    Optional<TimeZone> timezone();
}
