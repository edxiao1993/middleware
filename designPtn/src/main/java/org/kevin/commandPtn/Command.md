### start at November 29, 2021

命令模式：encapsulates a request as an object, thereby letting you parameterize other 
    objects with different requests, queue or log requests, and support undoable operation.
把命令封装成一个对象。

Command 的接口都有一个 execute 的方法，至于撤回操作，应该是由每一个具体的类自定义。
比如开灯的类：LightOnCommand，其 undo() 就应该是 .off();
而不应该由 Command 去定义 undo 具体的行为。
当然，这就需要在一开始就考虑要类的定义，但只是必要的。

这个模式的优势在于：完全的解耦。
ThreadPool 不就是这么用的吗……
