### start at November 8 - 2021

观察者模式：Attach additional responsibility to an object dynamically.
    Decorators provide a flexible alternative to subclassing for extending functionality.

通过继承，以及构造方法注入的模式，不断扩展父类原有的功能——准确地说应该是使某一具体的功能越来越具体。
拿书本上的例子，一开始定义一个 Beverage 的抽象类（Head First似乎特别喜欢抽象类），其实就是
规定哪一个功能可以不断被扩展。这种一开始就知道哪个功能会被动态修改的设计，感觉也并不是很难往观察者模式上靠。

总的来说，就是子类在构造方法里扩展父类，同时在具体的功能上，加上子类的功能。

---------------------
### date November 9
对于继承，以及父类的域，似乎还是有点模糊。
看来是之前写过太多的无谓的接口与继承了……
