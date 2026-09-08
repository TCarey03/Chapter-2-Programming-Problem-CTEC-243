Phase 1: Understanding the Stack Interface

LIFO, or Last-In, First-Out, is the correct behavior for an undo mechanism because the most recent change is normally the first change that a user wants to undo.

For example, if I type "one", then change it to "one two", and then change it to "one two three", pressing undo should remove the most recent change first. A stack handles this naturally because the newest state is placed on top of the stack and can be removed first.

FIFO would not work as well because it removes the oldest item first. That would mean undoing the oldest change before the most recent change, which is not how an undo feature normally works.

I tested the push, pop, peek, and isEmpty operations. The results showed that the stack follows LIFO behavior. This makes a stack a good choice for storing previous editor states.

---------------------

Phase 2: Building the Undo Engine

In Phase 2, I created the EditorHistory class and used a Stack<String> to store previous text states. I also created a String variable called currentState to keep track of the text that is currently in the editor.

Whenever makeChange() is called, the current state is pushed onto the undoStack before the current state is replaced with the new state. This allows the previous version of the text to be restored later.

The undo() method checks whether the undoStack is empty before trying to remove anything. If the stack is not empty, it pops the previous state and makes that the current state.

If a user calls undo() when no changes have been made, the undoStack is empty. I handled this by checking isEmpty() first. This prevents the program from trying to pop from an empty stack and leaves the current state unchanged.

One thing I learned from this phase is that the stack stores the previous versions of the text, while currentState keeps track of the version currently being displayed.

-----------------------

Phase 3: Adding the Redo Capability

In Phase 3, I added a second stack called redoStack to my EditorHistory class. The undoStack keeps track of states that can be restored with undo, while the redoStack keeps track of states that were undone and can potentially be restored with redo.

When undo() is called, the current state is pushed onto the redoStack before the previous state is taken from the undoStack. This allows the editor to return to that state if redo() is called.

When redo() is called, the current state is pushed back onto the undoStack and the state at the top of the redoStack becomes the current state.

I also made makeChange() clear the redoStack. This is necessary because making a brand-new change creates a new history path. The states that were previously available for redo are no longer relevant. For example, if I undo "one two three" and then type "one four", I should not be able to redo the old "one two three" change.

I also added checks for empty stacks so that calling undo() or redo() when there is nothing available does not cause an error.

---------------------------

Phase 4: Integration and Edge Cases

For my Phase 4 test, I started with an empty editor and typed three different states: "one", "one two", and "one two three".

After typing all three states, the undoStack contained the previous states while the redoStack was empty. I then called undo() twice. The first undo changed the current state from "one two three" to "one two". The second undo changed it from "one two" to "one". Each undone state was placed onto the redoStack.

Next, I called redo() once. This changed the current state from "one" back to "one two". The state that was redone was removed from the redoStack and the previous current state was placed on the undoStack.

After that, I made a brand-new change by changing the text to "one two four". Making this new change cleared the redoStack. This is necessary because the old redo history belongs to the previous version of the editing history. Once a new change is made, that old history should no longer be available.

Finally, I attempted to call redo(). Since the redoStack had been cleared, nothing happened and the current state remained "one two four".

The final stack states were:

undoStack: ["", "One", "One, Two"]
redoStack: []
currentState: "one two four"

This phase helped me understand how two stacks can work together to implement both undo and redo. I also learned why checking for empty stacks is important because the user may try to undo or redo when there is no history available.
