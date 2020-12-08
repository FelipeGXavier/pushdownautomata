package automata;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Automata {

    private String input;
    private HashMap<String, HashMap<TransitionInput, TransitionResult>> states;
    private List<State> acceptStates;
    private String initialState;
    private List<String> alphabet;
    private String initialStackInput;
    private Stack<String> stack = new Stack<>();

    public Automata(String input, HashMap<String, HashMap<TransitionInput, TransitionResult>> states, List<State> acceptStates, String initialState, List<String> alphabet, String initialStackInput) {
        this.input = input;
        this.states = states;
        this.acceptStates = acceptStates;
        this.initialState = initialState;
        this.alphabet = alphabet;
        this.initialStackInput = initialStackInput;
        this.stack.add("z0");
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public HashMap<String, HashMap<TransitionInput, TransitionResult>> getStates() {
        return states;
    }

    public void setStates(HashMap<String, HashMap<TransitionInput, TransitionResult>> states) {
        this.states = states;
    }

    public List<State> getAcceptStates() {
        return acceptStates;
    }

    public void setAcceptStates(List<State> acceptStates) {
        this.acceptStates = acceptStates;
    }

    public String getInitialState() {
        return initialState;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    public List<String> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<String> alphabet) {
        this.alphabet = alphabet;
    }

    public String getInitialStackInput() {
        return initialStackInput;
    }

    public void setInitialStackInput(String initialStackInput) {
        this.initialStackInput = initialStackInput;
    }

    public Stack<String> getStack() {
        return stack;
    }

    public void setStack(Stack<String> stack) {
        this.stack = stack;
    }

    public void pop() {
        this.stack.pop();
    }

    public void push(String symbol) {
        this.stack.push(symbol);
    }
}
