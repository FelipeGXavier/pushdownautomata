package automata;

public class TransitionResult {

    private String next;
    private String stackAction;

    public TransitionResult(String next, String stackAction) {
        this.next = next;
        this.stackAction = stackAction;
    }

    public String getNext() {
        return next;
    }

    public String getStackAction() {
        return stackAction;
    }
}
