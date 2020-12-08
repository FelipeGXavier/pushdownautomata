import automata.Automata;
import automata.State;
import automata.TransitionInput;
import automata.TransitionResult;
import builders.AutomataBuilder;
import builders.TransitionInputBuilder;
import builders.TransitionResultBuilder;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String input = "abxba";
        Automata automata =  new AutomataBuilder()
                .setInput(input)
                .setStates(transionfOfStateQ0())
                .setInitialState("q0")
                .createAutomata();
        System.out.println(automata);


    }

    public static HashMap<String, HashMap<TransitionInput, TransitionResult>> transionfOfStateQ0() {
        HashMap<String, HashMap<TransitionInput, TransitionResult>> states = new HashMap<>();
        HashMap<TransitionInput, TransitionResult> transitionsQ0 = new HashMap<>();
        HashMap<TransitionInput, TransitionResult> transitionsQ1 = new HashMap<>();
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
        //TransitionInput t4 = new TransitionInputBuilder().setInput("1").setLastElementStack("1").createTransitionInput();
        //TransitionResult r4 = new TransitionResultBuilder().setNext(q0).setStackAction("push 1").createTransitionResult();
        transitionsQ0.put(t1, r1);
        transitionsQ0.put(t2, r2);
        transitionsQ0.put(t3, r3);
        states.put("q0", transitionsQ0);
        return states;
    }


}
