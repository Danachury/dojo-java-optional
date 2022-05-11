package com.danachury.samples.dojojavaoptional.immutables.entities;

import com.danachury.samples.dojojavaoptional.immutables.valueobjects.IncidentStatus;
import com.danachury.samples.dojojavaoptional.immutables.valueobjects.Url;
import com.fasterxml.jackson.databind.JsonNode;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
public interface Incident {

    Company company();

    Offering offering();

    Service service();

    Optional<Brand> brand();

    Optional<Url> targetUrl();

    IncidentStatus status();

    String type();

    String proactiveSource();

    Boolean isProactiveDetection();

    Boolean isTakedownPerformed();

    Optional<String> description();

    Optional<String> nature();

    Optional<String> level();

    Optional<Double> score();

    Optional<JsonNode> sourceData();

    Optional<Country> originCountry();

    Optional<Url> url();

    Optional<Url> redirectUrl();

    Optional<String> hosting();

    default boolean isNotApplicable() {
        return this.level()
            .map(level -> this.score().orElse(0.0) <= 0 && level.equals("NOT_APPLICABLE"))
            .orElse(false);
    }
}
