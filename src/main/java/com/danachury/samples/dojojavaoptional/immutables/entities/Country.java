package com.danachury.samples.dojojavaoptional.immutables.entities;

import org.immutables.value.Value;

@Value.Immutable
public interface Country {

    String code();

    String name();
}
