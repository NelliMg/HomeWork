package sets.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Glasses implements Comparable<Glasses> {
    private  Color color;
    private Size size;

    public Glasses(Color color, Size size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Glasses glasses = (Glasses) o;
        return color == glasses.color &&
                size == glasses.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size);
    }

    @Override
    public int compareTo(@NotNull Glasses glasses) {
        Color comparableColor=glasses.color;
        Size comparableSize=glasses.size;
        return this.size.name().compareTo(comparableSize.name())==0
                ? this.color.name().compareTo(comparableColor.name())
                :this.size.name().compareTo(comparableSize.name());

    }

    @Override
    public String toString() {
        return "Glass:"+color +", " + size ;
    }
}
