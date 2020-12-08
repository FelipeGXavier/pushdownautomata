package automata;

import builders.TransitionInputBuilder;

public class Processor {

    private final Automata automata;
    private String current;

    public Processor(Automata automata) {
        this.current = automata.getInitialState();
        this.automata = automata;
    }

    public void procces() {
        while (!this.automata.getInput().equals("")) {
            String input = this.automata.getInput().substring(1);
            TransitionInput transitionInput = new TransitionInputBuilder().setInput(input).setLastElementStack(this.automata.getStack().peek()).createTransitionInput();

            this.automata.setInput("");
        }
    }
}
