public class Main {
    public static void main(String[] args) {

        EditorHistory editor = new EditorHistory();

        // Type three words
        editor.makeChange("one");
        System.out.println("1. Type one: " + editor.currentStatus());

        editor.makeChange("one two");
        System.out.println("2. Type two: " + editor.currentStatus());

        editor.makeChange("one two three");
        System.out.println("3. Type three: " + editor.currentStatus());

        // Undo twice
        editor.undo();
        System.out.println("4. Undo: " + editor.currentStatus());

        editor.undo();
        System.out.println("5. Undo: " + editor.currentStatus());

        // Redo once
        editor.redo();
        System.out.println("6. Redo: " + editor.currentStatus());

        // Make a brand-new change
        editor.makeChange("one two four");
        System.out.println("7. New change: " + editor.currentStatus());

        // Attempt to redo
        editor.redo();
        System.out.println("8. Attempt redo: " + editor.currentStatus());
    }
}
