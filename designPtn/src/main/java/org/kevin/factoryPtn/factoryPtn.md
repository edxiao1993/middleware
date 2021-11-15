### start at November 15 - 2021

一星期学一个设计模式吗？怎么恰好都隔着七天。。。。。。


工厂模式：defines an interface for creating an object, but lets subclasses decide
    which class to instantiate. Factory Method lets a class defer instantiation to subclass.
一个工厂接口用来创建一个对象，但是选择让子类去实现一个具体的对象。
换种表达方式：如果有一系列的对象都有相似的行为，那么就把相同的部分提取出来，放到一个抽象类里，最终让
具体的子类去实现一个对象。比如 pizza 都有类似的做法：准备材料，添加材料，烘焙，切割，装盘 ……
  但是不同店铺的 pizza 提供不同类型的选择，比如加重芝士的量，比如提供默认的大小等等。

还有个 简单工厂模式，就是在一个类里实现所有的子类，通过传进来的 type。应该不会用到。

这里用到的设计原则是 依赖反转原则：依赖于抽象，而不是具体。
这话的意思不就是面对抽象编程吗？
high-level component：定义了 low-level 组件的组件。
回到这里的例子，就是 PizzaStore 依赖于 Pizza，但 Pizza 的具体实现是 NYStyleMeatPizza

写到这里我才注意到，pizza 的生产，没有用到关键字 new

``` 典型的工厂方法：
abstract Product factoryMethod(String type);
抽象，留给子类实现 ｜ 产品，一般是某类产品共同的接口 ｜ 
```