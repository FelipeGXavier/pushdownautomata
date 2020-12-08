package builders;

import automata.Automata;
import automata.TransitionInput;
import automata.TransitionResult;

import java.util.HashMap;
import java.util.List;

public class AutomataBuilder {
    private String input;
    private HashMap<String, HashMap<TransitionInput, TransitionResult>> states;
    private List<String> acceptStates;
    private String initialState;
    private List<String> alphabet;
    private String initialStackInput;
    private List<String> stackAlphabet;

    public AutomataBuilder setInput(String input) {
        this.input = input;
        return this;
    }

    public AutomataBuilder setStates(HashMap<String, HashMap<TransitionInput, TransitionResult>> states) {
        this.states = states;
        return this;
    }

    public AutomataBuilder setAcceptStates(List<String> acceptStates) {
        this.acceptStates = acceptStates;
        return this;
    }

    public AutomataBuilder setInitialState(String initialState) {
        this.initialState = initialState;
        return this;
    }

    public AutomataBuilder setAlphabet(List<String> alphabet) {
        this.alphabet = alphabet;
        return this;
    }

    public AutomataBuilder setInitialStackInput(String initialStackInput) {
        this.initialStackInput = initialStackInput;
        return this;
    }

    public AutomataBuilder setStackAlphabet(List<String> stackAlphabet) {
        this.stackAlphabet = stackAlphabet;
        return this;
    }

    public Automata createAutomata() {
        return new Automata(input, states, acceptStates, initialState, alphabet, initialStackInput, stackAlphabet);
    }
}