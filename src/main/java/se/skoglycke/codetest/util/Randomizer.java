package se.skoglycke.codetest.util;

import java.util.concurrent.ThreadLocalRandom;

public final class Randomizer {

    private Randomizer() {
    }

    /**
     * getRandomNumber(3) = One of 0, 1, 2
     * @param maxNumber exclusive
     * @return a number between 0 and maxNumber
     */
    public static int getRandomNumber(final int maxNumber) {
        return ThreadLocalRandom.current().nextInt(maxNumber);
    }

}
