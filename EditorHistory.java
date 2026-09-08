public class EditorHistory {

    private Stack<String> undoStack;
    private String currentState;

    public EditorHistory() {
        undoStack = new Stack<>();
        currentState = "";
    }

    public void makeChange(String newState) {
        undoStack.push(currentState);
        currentState = newState;
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            currentState = undoStack.pop();
        }
    }

    public String currentStatus() {
        return currentState;
    }
}
