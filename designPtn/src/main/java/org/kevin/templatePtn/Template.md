### start at December 17, 2021

模版模式：defines the skeleton of an algorithm in a method, 
    deferring some steps to subclasses. Template Method lets subclasses redefine
    certain steps of an algorithm without changing the algorithm's structure.
定义一套算法的骨架，即 一、二、三、四步地往下走。其中某些步骤是可以被替换的。


往大的方向扩展了说，可以这么认为，一个外卖的单，从下单到完成经过的步骤：
1）用户下单 --- 实现的方式可以是 网页，或者 APP，比起简单的一个方法，它也可以是一个复杂的类
2）平台接单，并推送给商家：这是固定的步骤，可以在 抽象类 里面直接实现。
3）卖家处理 --- 这也可以是一个复杂的类。
4）平台通知骑手可以去拿外卖了：这也是固定的步骤，抽象类 里面实现。

好吧，有点怪怪的，但意思差不多。
其实这跟策略模式有点类似，而策略模式在现实中的例子，公交车就是个很好的例子：
老年人的公交卡打六折，学生卡打五折，微信打八折，现金不打折。
其实现方式就是定义个接口，但具体的实现方式由子类去实现。

而模版模式，相当于把上面的实现抽出来一些通用的步骤，把特殊的步骤留待子类实现。
嗯，融会贯通了～