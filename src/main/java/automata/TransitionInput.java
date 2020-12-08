package automata;

import java.util.Objects;

public class TransitionInput {

    private String input;
    private String lastElementStack;

    public TransitionInput(String input, String lastElementStack) {
        this.input = input;
        this.lastElementStack = lastElementStack;
    }

    public String getInput() {
        return input;
    }

    public String getLastElementStack() {
        return lastElementStack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransitionInput that = (TransitionInput) o;
        return input.equals(that.input) && Objects.equals(lastElementStack, that.lastElementStack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, lastElementStack);
    }
}
