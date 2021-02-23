package se.skoglycke.codetest.montyhall;

public class GameProperties {

    private static final int LEAST_NUMBER_OF_BOXES_ALLOWED = 3;

    private final int numberOfBoxes;

    private GameProperties(final int numberOfBoxes) {
        this.numberOfBoxes = numberOfBoxes;
    }

    public static GameProperties validate(final int numberOfBoxes) {
        return new GameProperties(
                validateNumberOfBoxes(numberOfBoxes)
        );
    }

    private static int validateNumberOfBoxes(final int numberOfBoxes) {
        if (numberOfBoxes < LEAST_NUMBER_OF_BOXES_ALLOWED) {
            throw new IllegalArgumentException("numberOfBoxes needs to be at least: " + LEAST_NUMBER_OF_BOXES_ALLOWED);
        }
        return numberOfBoxes;
    }

    public int getNumberOfBoxes() {
        return numberOfBoxes;
    }

}
