package se.skoglycke.codetest.montyhall;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static se.skoglycke.codetest.montyhall.Content.EMPTY;
import static se.skoglycke.codetest.montyhall.Content.MONEY;
import static se.skoglycke.codetest.montyhall.Result.LOST;
import static se.skoglycke.codetest.montyhall.Result.WON;
import static se.skoglycke.codetest.util.Randomizer.getRandomNumber;

public class MontyHallProblem {

    private final int numberOfBoxes;

    public MontyHallProblem(final GameProperties gameProperties) {
        this.numberOfBoxes = gameProperties.getNumberOfBoxes();
    }

    public Result play(final Strategy strategy) {

        final List<Box> boxes = getGameShowBoxes();

        // Game participant choose random box
        boxes.get(getRandomNumber(numberOfBoxes)).setPicked(true);

        final List<Box> boxesAfterRemoval = removeOneEmptyBox(boxes);

        return switch (strategy) {
            case SWITCH -> boxesAfterRemoval.stream()
                        .filter(Box::isNotPicked)
                        .findFirst()
                        .map(box -> box.hasMoney() ? WON : LOST)
                        .orElseThrow(); // Could do a .get() instead, would love some feedback here :)

            case STAY -> boxesAfterRemoval.stream()
                        .filter(Box::isPicked)
                        .findFirst()
                        .map(box -> box.hasMoney() ? WON : LOST)
                        .orElseThrow(); // Same
        };
    }

    private List<Box> removeOneEmptyBox(final List<Box> boxes) {

        final AtomicBoolean isOneRemoved = new AtomicBoolean(false);

        return boxes.stream()
                .flatMap(box -> {
                    if (!isOneRemoved.get() && !box.isPicked() && box.isEmpty()) {
                        isOneRemoved.set(true);
                        return Stream.empty();
                    }
                    return Stream.of(box);
                })
                .collect(toList());
    }

    private List<Box> getGameShowBoxes() {
        final List<Box> emptyBoxes = Stream
                .generate(() -> new Box(EMPTY))
                .limit(numberOfBoxes)
                .collect(toList());

        return putMoneyInRandomBox(emptyBoxes);
    }

    private List<Box> putMoneyInRandomBox(final List<Box> boxes) {
        final int randomNumber = getRandomNumber(boxes.size());
        boxes.get(randomNumber).setContent(MONEY);
        return boxes;
    }

}
