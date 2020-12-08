package builders;

import automata.TransitionResult;

public class TransitionResultBuilder {
    private String next;
    private String stackAction;

    public TransitionResultBuilder setNext(String next) {
        this.next = next;
        return this;
    }

    public TransitionResultBuilder setStackAction(String stackAction) {
        this.stackAction = stackAction;
        return this;
    }

    public TransitionResult createTransitionResult() {
        return new TransitionResult(next, stackAction);
    }
}