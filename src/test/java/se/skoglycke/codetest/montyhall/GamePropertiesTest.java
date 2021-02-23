package se.skoglycke.codetest.montyhall;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GamePropertiesTest {

    @Test
    void validate_numberOfBoxesIsTwo_throwError() {

        final String errorMsg = assertThrows(
                IllegalArgumentException.class,
                () -> GameProperties.validate(2))
                .getMessage();

        assertThat(errorMsg).isEqualTo("numberOfBoxes needs to be at least: 3");
    }

    @Test
    void validate_numberOfBoxesIsThree_throwError() {
        final GameProperties gameProperties = GameProperties.validate(3);
        assertThat(gameProperties.getNumberOfBoxes()).isEqualTo(3);
    }

    @Test
    void validate_numberOfBoxesIsTwelve_throwError() {
        final GameProperties gameProperties = GameProperties.validate(12);
        assertThat(gameProperties.getNumberOfBoxes()).isEqualTo(12);
    }
}