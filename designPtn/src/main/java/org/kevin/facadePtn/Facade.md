### start at December 13, 2021

外观模式：provides a unified interface to a set of interfaces 
    in a subsystem. Facade defines a higher-level interface that makes the subsystem 
    easier to use.
原来中文名称是 外观模式，看的时候一直以为是 级联模式。。。。。。

说白了就是把一堆接口封装到一个接口里面，调用者只需要考虑如何使用外观模式提供的接口就行。
封装了底层实现，好处是不需要考虑太多因素；坏处当然也显而易见：灵活性大大地降低了。
  不过以我写了三年多的代码的经验来看，被牺牲掉的灵活性简直可以忽略不计～

应用到的设计原则，是 最小知道原则：
  Least knowledge: talk only to your immediate friends.
是不是也叫 迪米特里法则 来着？