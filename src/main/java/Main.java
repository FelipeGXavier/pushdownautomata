import automata.*;
import builders.AutomataBuilder;
import builders.TransitionInputBuilder;
import builders.TransitionResultBuilder;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> acceptedStates = new ArrayList<>(Collections.singletonList("q2"));
        List<String> alphabhet = new ArrayList<>(Arrays.asList("0","1"));
        List<String> stackAlphabet = new ArrayList<>(Arrays.asList("0","1", "z0"));
        String initialSymbolStack = "z0";
        String input = "0x0";
        Automata automata =  new AutomataBuilder()
                .setInput(input)
                .setInitialStackInput(initialSymbolStack)
                .setAlphabet(alphabhet)
                .setStackAlphabet(stackAlphabet)
                .setAcceptStates(acceptedStates)
                .setStates(loadTransitions())
                .setInitialState("q0")
                .createAutomata();
        Processor processor = new Processor(automata);
        processor.proccess();
        System.out.println(processor.isAccepted());
    }

    public static HashMap<String, HashMap<TransitionInput, TransitionResult>> loadTransitions() {
        HashMap<String, HashMap<TransitionInput, TransitionResult>> states = new HashMap<>();
        // Inicia transições
        HashMap<TransitionInput, TransitionResult> transitionsQ0 = new HashMap<>();
        HashMap<TransitionInput, TransitionResult> transitionsQ1 = new HashMap<>();
        HashMap<TransitionInput, TransitionResult> transitionsQ2 = new HashMap<>();

        // Transição 1
        TransitionInput t1 = new TransitionInputBuilder().setInput("0").setLastElementStack("z0").createTransitionInput();
        TransitionResult r1 = new TransitionResultBuilder().setNext("q0").setStackAction("push 0").createTransitionResult();
        // Transição 2
        TransitionInput t2 = new TransitionInputBuilder().setInput("1").setLastElementStack("z0").createTransitionInput();
        TransitionResult r2 = new TransitionResultBuilder().setNext("q0").setStackAction("push 1").createTransitionResult();
        // Transição 3
        TransitionInput t3 = new TransitionInputBuilder().setInput("0").setLastElementStack("0").createTransitionInput();
        TransitionResult r3 = new TransitionResultBuilder().setNext("q0").setStackAction("push 0").createTransitionResult();
        // Transição 4
        TransitionInput t4 = new TransitionInputBuilder().setInput("1").setLastElementStack("1").createTransitionInput();
        TransitionResult r4 = new TransitionResultBuilder().setNext("q0").setStackAction("push 1").createTransitionResult();
        // Transição 5
        TransitionInput t5 = new TransitionInputBuilder().setInput("1").setLastElementStack("0").createTransitionInput();
        TransitionResult r5 = new TransitionResultBuilder().setNext("q0").setStackAction("push 1").createTransitionResult();
        // Transição 6
        TransitionInput t6 = new TransitionInputBuilder().setInput("0").setLastElementStack("1").createTransitionInput();
        TransitionResult r6 = new TransitionResultBuilder().setNext("q0").setStackAction("push 0").createTransitionResult();
        // Transição 7
        TransitionInput t7 = new TransitionInputBuilder().setInput("x").setLastElementStack("0").createTransitionInput();
        TransitionResult r7 = new TransitionResultBuilder().setNext("q1").setStackAction("lambda").createTransitionResult();
        // Transição 8
        TransitionInput t8 = new TransitionInputBuilder().setInput("x").setLastElementStack("1").createTransitionInput();
        TransitionResult r8 = new TransitionResultBuilder().setNext("q1").setStackAction("lambda").createTransitionResult();
        // Transição 9
        TransitionInput t9 = new TransitionInputBuilder().setInput("0").setLastElementStack("0").createTransitionInput();
        TransitionResult r9 = new TransitionResultBuilder().setNext("q1").setStackAction("pop").createTransitionResult();
        // Transição 10
        TransitionInput t10 = new TransitionInputBuilder().setInput("1").setLastElementStack("1").createTransitionInput();
        TransitionResult r10 = new TransitionResultBuilder().setNext("q1").setStackAction("pop").createTransitionResult();
        // Transição 11
        TransitionInput t11 = new TransitionInputBuilder().setInput("B").setLastElementStack("z0").createTransitionInput();
        TransitionResult r11 = new TransitionResultBuilder().setNext("q2").setStackAction("pop").createTransitionResult();

        transitionsQ0.put(t1, r1);
        transitionsQ0.put(t2, r2);
        transitionsQ0.put(t3, r3);
        transitionsQ0.put(t4, r4);
        transitionsQ0.put(t5, r5);
        transitionsQ0.put(t6, r6);
        transitionsQ0.put(t7, r7);
        transitionsQ0.put(t8, r8);

        transitionsQ1.put(t9, r9);
        transitionsQ1.put(t10, r10);
        transitionsQ1.put(t11, r11);

        states.put("q0", transitionsQ0);
        states.put("q1", transitionsQ1);
        states.put("q2", transitionsQ2);
        return states;
    }


}
