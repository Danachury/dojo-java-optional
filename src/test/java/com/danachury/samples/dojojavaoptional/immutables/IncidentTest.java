package com.danachury.samples.dojojavaoptional.immutables;

import com.danachury.samples.dojojavaoptional.immutables.entities.ImmutableIncident;
import com.danachury.samples.dojojavaoptional.immutables.valueobjects.Url;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.danachury.samples.dojojavaoptional.mothers.IncidentMother.incidentMother;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IncidentTest {

    @ParameterizedTest
    @ValueSource(strings = {"https://google.com", "https://easysol.net", "https://facebook.com"})
    void shouldUpdateIncidentUrl(String url) {
        // Given
        final var incident = ImmutableIncident.copyOf(incidentMother());
        assertTrue(incident.url().isEmpty());

        // When
        final var updatedIncident = incident.withUrl(new Url(url));
        assertEquals(url, updatedIncident.url().map(Url::value).orElse(null));

        // Then ? This assertion will pass?
        assertTrue(incident.url().isEmpty());
        assertEquals(url, updatedIncident.url().map(Url::value).orElse(null));
    }
}
