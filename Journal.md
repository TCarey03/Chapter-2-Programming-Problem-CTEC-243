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
