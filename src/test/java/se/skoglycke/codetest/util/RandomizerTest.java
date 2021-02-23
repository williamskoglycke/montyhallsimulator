package se.skoglycke.codetest.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomizerTest {

    @Test
    void getRandomNumber() {

        for (int i = 0; i < 100; i++) {
            final int randomNumber = Randomizer.getRandomNumber(3);
            assertThat(randomNumber)
                    .isLessThanOrEqualTo(2)
                    .isGreaterThanOrEqualTo(0);
        }

    }
}