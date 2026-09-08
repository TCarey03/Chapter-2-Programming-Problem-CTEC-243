public class Main {
    public static void main(String[] args) {

        EditorHistory editor = new EditorHistory();

        System.out.println("Current: " + editor.currentStatus());

        editor.makeChange("one");
        System.out.println("After first change: " + editor.currentStatus());

        editor.makeChange("one two");
        System.out.println("After second change: " + editor.currentStatus());

        editor.undo();
        System.out.println("After undo: " + editor.currentStatus());

        editor.undo();
        System.out.println("After second undo: " + editor.currentStatus());

        editor.undo();
        System.out.println("After undo with no changes: " + editor.currentStatus());
    }
}
