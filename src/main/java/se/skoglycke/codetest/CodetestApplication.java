package se.skoglycke.codetest;

import se.skoglycke.codetest.montyhall.GameProperties;
import se.skoglycke.codetest.montyhall.MontyHallProblem;
import se.skoglycke.codetest.montyhall.Strategy;

import java.util.stream.Stream;

import static se.skoglycke.codetest.montyhall.Result.WON;
import static se.skoglycke.codetest.montyhall.Strategy.STAY;
import static se.skoglycke.codetest.montyhall.Strategy.SWITCH;

public class CodetestApplication {

    private static final int NUMBER_OF_ITERATIONS = 1000;
    private static final int NUMBER_OF_BOXES = 3;

    public static void main(String[] args) {

        final GameProperties gameProperties = GameProperties.validate(NUMBER_OF_BOXES);
        final MontyHallProblem montyHallProblem = new MontyHallProblem(gameProperties);

        final long switchWins = Stream
                .generate(() -> montyHallProblem.play(Strategy.SWITCH))
                .limit(NUMBER_OF_ITERATIONS)
                .filter(WON::equals)
                .count();

        final long stayWins = Stream
                .generate(() -> montyHallProblem.play(Strategy.STAY))
                .limit(NUMBER_OF_ITERATIONS)
                .filter(WON::equals)
                .count();

        System.out.printf("""
                Iterations of each: %d,
                Number of boxes: %d,
                'Switch' wins: %d
                'Stay' wins: %d
                
                Best strategy: %s
                """,
                NUMBER_OF_ITERATIONS,
                NUMBER_OF_BOXES,
                switchWins,
                stayWins,
                (switchWins > stayWins) ? SWITCH : STAY);
    }

}
