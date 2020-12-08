package automata;

import java.util.*;

public class Automata {

    private String input;
    private HashMap<String, HashMap<TransitionInput, TransitionResult>> states;
    private List<String> acceptStates;
    private String initialState;
    private List<String> alphabet;
    private String initialStackInput;
    private Stack<String> stack = new Stack<>();
    private List<String> stackAlphabet;

    public Automata(
            String input,
            HashMap<String, HashMap<TransitionInput, TransitionResult>> states,
            List<String> acceptStates,
            String initialState,
            List<String> alphabet,
            String initialStackInput,
            List<String> stackAlphabet) {
        this.input = input;
        this.states = states;
        this.acceptStates = acceptStates;
        this.initialState = initialState;
        this.alphabet = alphabet;
        this.initialStackInput = initialStackInput;
        this.stackAlphabet = stackAlphabet;
        this.stack.add(initialStackInput);
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

    public List<String> getAcceptStates() {
        return acceptStates;
    }

    public void setAcceptStates(List<String> acceptStates) {
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

    public List<String> getStackAlphabet() {
        return stackAlphabet;
    }

    public void setStackAlphabet(List<String> stackAlphabet) {
        this.stackAlphabet = stackAlphabet;
    }

    public void display(){
        System.out.println("Estado inicial: " + this.initialState);
        System.out.println("Estados: " + String.join(",", this.states.keySet()));
        System.out.println("Estados de aceitação: " + String.join(",", this.acceptStates));
        System.out.println("Alfabeto: " + String.join(",", this.alphabet));
        System.out.println("Alfabeto da pilha: " + String.join(",", this.stackAlphabet));
        System.out.println("Símbolo inicial da pilha: " + this.initialStackInput);
    }

    public void pop() {
        this.stack.pop();
    }

    public void push(String symbol) {
        this.stack.push(symbol);
    }
}
