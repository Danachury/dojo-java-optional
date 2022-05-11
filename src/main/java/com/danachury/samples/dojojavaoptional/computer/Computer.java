package com.danachury.samples.dojojavaoptional.computer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
public class Computer {

    private SoundCard soundCard; // No do this in a class

    public Optional<SoundCard> getSoundCard() {
        return Optional.ofNullable(this.soundCard);
    }
}
