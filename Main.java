public class Main {
    public static void main(String[] args) {

        EditorHistory editor = new EditorHistory();

        editor.makeChange("one");
        System.out.println("Current: " + editor.currentStatus());

        editor.makeChange("one two");
        System.out.println("Current: " + editor.currentStatus());

        editor.undo();
        System.out.println("After undo: " + editor.currentStatus());

        editor.redo();
        System.out.println("After redo: " + editor.currentStatus());

        editor.undo();
        System.out.println("After second undo: " + editor.currentStatus());

        editor.makeChange("one three");
        System.out.println("After new change: " + editor.currentStatus());

        editor.redo();
        System.out.println("After attempting redo: " + editor.currentStatus());
    }
}
