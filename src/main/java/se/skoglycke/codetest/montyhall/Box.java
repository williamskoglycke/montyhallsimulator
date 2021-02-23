package se.skoglycke.codetest.montyhall;

import static java.util.Objects.requireNonNull;
import static se.skoglycke.codetest.montyhall.Content.EMPTY;
import static se.skoglycke.codetest.montyhall.Content.MONEY;

public class Box {
    private Content content;
    private boolean isPicked;

    public Box(final Content content) {
        this.content = requireNonNull(content, "content cannot be null");
        this.isPicked = false;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(final Content content) {
        this.content = requireNonNull(content, "content cannot be null");
    }

    public boolean isPicked() {
        return isPicked;
    }

    public boolean isNotPicked() {
        return !isPicked;
    }

    public void setPicked(final boolean picked) {
        isPicked = picked;
    }

    public boolean isEmpty() {
        return content.equals(EMPTY);
    }

    public boolean hasMoney() {
        return content.equals(MONEY);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Box box = (Box) o;

        return content == box.content;
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }

    @Override
    public String toString() {
        return "Content: " + content.name();
    }
}
