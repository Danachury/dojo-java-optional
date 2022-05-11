package com.danachury.samples.dojojavaoptional.mothers;

import com.danachury.samples.dojojavaoptional.immutables.entities.*;
import com.danachury.samples.dojojavaoptional.immutables.valueobjects.IncidentStatus;

import java.util.Optional;
import java.util.TimeZone;

public class IncidentMother {

    public static Incident incidentMother() {
        return ImmutableIncident.builder()
            .company(ImmutableCompany.builder().publicId("APPGATE").name("Appgate").timezone(Optional.of(TimeZone.getDefault())).build())
            .offering(ImmutableOffering.builder().name("DRP").enabled(true).build())
            .service(ImmutableService.builder().name("DRP Premium").enabled(true).build())
            .status(IncidentStatus.CLOSED)
            .type("REPOSITORY")
            .proactiveSource("Immuniweb")
            .isProactiveDetection(true)
            .isTakedownPerformed(false)
            .build();
    }
}
