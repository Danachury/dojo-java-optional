package com.danachury.samples.dojojavaoptional.immutables.entities;

import org.immutables.value.Value;

@Value.Immutable
public interface Service {

    String name();

    Boolean enabled();
}
