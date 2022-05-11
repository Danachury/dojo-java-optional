package com.danachury.samples.dojojavaoptional;

import com.danachury.samples.dojojavaoptional.immutables.entities.*;
import com.danachury.samples.dojojavaoptional.immutables.valueobjects.IncidentStatus;
import com.danachury.samples.dojojavaoptional.immutables.valueobjects.Url;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.TimeZone;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // buildInvalidIncident();
        // buildWithoutOptionalFields();
        buildCompleteIncident();
    }

    private static void buildInvalidIncident() {
        final Incident incident = ImmutableIncident.builder()
            .build();
        System.out.println(incident);
    }

    private static void buildWithoutOptionalFields() {
        final var incident = ImmutableIncident.builder()
            .company(ImmutableCompany.builder().publicId("APPGATE").name("Appgate").timezone(Optional.of(TimeZone.getDefault())).build())
            .offering(ImmutableOffering.builder().name("DRP").enabled(true).build())
            .service(ImmutableService.builder().name("DRP Premium").enabled(true).build())
            .status(IncidentStatus.CLOSED)
            .type("REPOSITORY")
            .proactiveSource("Immuniweb")
            .isProactiveDetection(true)
            .isTakedownPerformed(false)
            .build();
        System.out.println(incident);
    }

    private static void buildCompleteIncident() {
        final var threatScore = Math.random();
        final var threatLevel = threatScore > Math.round(.13543) ? null : "INFO";
        final var incident = ImmutableIncident.builder()
            .company(ImmutableCompany.builder().publicId("APPGATE").name("Appgate").timezone(Optional.of(TimeZone.getDefault())).build())
            .offering(ImmutableOffering.builder().name("DRP").enabled(true).build())
            .service(ImmutableService.builder().name("DRP Premium").enabled(true).build())
            .brand(ImmutableBrand.builder().name("appgate").build())
            .targetUrl(new Url("https://appgate.com"))
            .status(IncidentStatus.CLOSED)
            .type("REPOSITORY")
            .proactiveSource("Immuniweb")
            .isProactiveDetection(true)
            .isTakedownPerformed(false)
            .description("This incident is result of a Dojo with immutables.org")
            .nature("IMMUTABLE")
            .level(Optional.ofNullable(threatLevel))
            .score(threatScore)
            .sourceData(new JsonMapper().createObjectNode())
            .originCountry(ImmutableCountry.builder().code("CO").name("Colombia").build())
            .url(Optional.empty())
            .redirectUrl(Optional.empty())
            .hosting(Optional.empty())
            .build();
        System.out.println(incident);
    }
}
