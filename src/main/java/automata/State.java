package automata;

import java.util.HashMap;
import java.util.Objects;

public class State {

    private String name;
    private HashMap<TransitionInput, TransitionResult> transitions = new HashMap<>();

    public State(String name) {
        this.name = name;
    }

   public void addTransition(TransitionInput input, TransitionResult result){
        this.transitions.put(input, result);
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return name.equals(state.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
