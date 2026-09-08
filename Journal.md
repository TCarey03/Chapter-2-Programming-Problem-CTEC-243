Phase 1: Understanding the Stack Interface

LIFO, or Last-In, First-Out, is the correct behavior for an undo mechanism because the most recent change is normally the first change that a user wants to undo.

For example, if I type "one", then change it to "one two", and then change it to "one two three", pressing undo should remove the most recent change first. A stack handles this naturally because the newest state is placed on top of the stack and can be removed first.

FIFO would not work as well because it removes the oldest item first. That would mean undoing the oldest change before the most recent change, which is not how an undo feature normally works.

I tested the push, pop, peek, and isEmpty operations. The results showed that the stack follows LIFO behavior. This makes a stack a good choice for storing previous editor states.
