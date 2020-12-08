package builders;

import automata.TransitionInput;

public class TransitionInputBuilder {
    private String input;
    private String lastElementStack;

    public TransitionInputBuilder setInput(String input) {
        this.input = input;
        return this;
    }

    public TransitionInputBuilder setLastElementStack(String lastElementStack) {
        this.lastElementStack = lastElementStack;
        return this;
    }

    public TransitionInput createTransitionInput() {
        return new TransitionInput(input, lastElementStack);
    }
}