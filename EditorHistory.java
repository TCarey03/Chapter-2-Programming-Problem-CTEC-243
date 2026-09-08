public class EditorHistory {

    private Stack<String> undoStack;
    private Stack<String> redoStack;
    private String currentState;

    public EditorHistory() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        currentState = "";
    }

    public void makeChange(String newState) {
        undoStack.push(currentState);
        currentState = newState;

        // A new change makes the old redo history invalid
        redoStack = new Stack<>();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentState);
            currentState = undoStack.pop();
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentState);
            currentState = redoStack.pop();
        }
    }

    public String currentStatus() {
        return currentState;
    }
}
