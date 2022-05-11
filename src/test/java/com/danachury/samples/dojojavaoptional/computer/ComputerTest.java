package com.danachury.samples.dojojavaoptional.computer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ComputerTest {

    @Test
    void shouldNoRetrieveSoundCard() {
        // Given
        final var computer = new Computer();

        // Then
        assertTrue(computer.getSoundCard().isEmpty());
    }

    @Test
    void shouldRetrieveSoundCard() {
        // Given
        final var soundCard = new SoundCard(new Usb("v1.0"));
        final var computer = new Computer(soundCard);

        // Then
        assertTrue(computer.getSoundCard().isPresent());
        final var version = computer.getSoundCard()
            .flatMap(SoundCard::getUsb)
            .map(Usb::version)
            .orElse("UNKNOWN");
        assertEquals("v1.0", version);
    }
}
