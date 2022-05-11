package com.danachury.samples.dojojavaoptional.computer;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class SoundCard {

    private final Usb usb;

    public Optional<Usb> getUsb() {
        return Optional.ofNullable(this.usb);
    }
}
