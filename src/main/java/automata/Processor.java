package automata;

import builders.TransitionInputBuilder;

import java.util.HashMap;

public class Processor {

    private final Automata automata;
    private String current;

    public Processor(Automata automata) {
        this.current = automata.getInitialState();
        this.automata = automata;
        this.automata.setInput(this.addUsefulTokens(this.automata.getInput()));
    }

    public void proccess() {
        HashMap<String, HashMap<TransitionInput, TransitionResult>> states =
                this.automata.getStates();
        while (!this.automata.getInput().equals("")) {
            String input = this.automata.getInput().substring(0, 1);
            TransitionInput transitionInput =
                    new TransitionInputBuilder()
                            .setInput(input)
                            .setLastElementStack(this.automata.getStack().peek())
                            .createTransitionInput();
            if (states.containsKey(this.current)
                    && states.get(this.current).containsKey(transitionInput)) {
                this.doActionInStack(states.get(this.current).get(transitionInput));
            }
            this.automata.setInput(this.automata.getInput().substring(1));
        }
    }

    public boolean isAccepted() {
        if (this.automata.getStack().isEmpty()) {
            return this.automata.getAcceptStates().stream()
                    .anyMatch(state -> state.equals(this.current));
        }
        return false;
    }

    public void doActionInStack(TransitionResult transitionResult) {
        String newState = transitionResult.getNext();
        String action = transitionResult.getStackAction();
        if (action.contains("push")) {
            this.automata.push(action.substring(action.length() - 1));
        } else if (action.contains("pop")) {
            this.automata.pop();
            ;
        }
        this.current = newState;
    }

    public String addUsefulTokens(String input) {
        String endOfLineSymbol = "B";
        if (input.length() == 2) {
            input = input.charAt(0) + "x" + input.charAt(1);
        } else if (input.length() % 2 == 0) {
            int middle = input.length() / 2;
            input = input.substring(0, middle - 1) + "x" + input.substring(middle - 1);
        }
        input = input + endOfLineSymbol;
        return input;
    }
}
