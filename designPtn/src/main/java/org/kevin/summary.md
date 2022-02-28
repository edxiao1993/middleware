### start at February 28, 2022

面向对象编程的四个基础：
1. Abstraction - 抽象
2. Encapsulation - 封装
3. Polymorphism - 多态(interface)
4. Inheritance - 继承

面向对象的设计原则：
1. Encapsulate what varies; (比如不同的鸭子的叫声不一样)
2. Favor composition over; （偏向于组合，比如鸭子的叫声，飞行的动作，名称…… 将前两者抽象出来组合到鸭子这个对象中）
3. Program to interface, not implementation; （修改实现时可以不需要修改调用的代码）
4. Strive for loosely coupled designs between objects that interact. （松耦合。这个应该是在设计所有对象时都优先考虑的原则）
5. Classes should be open for extension but closed for modification. (继承并添加功能？可以这么理解)
6. Depend on abstractions. Do not depend on concrete classes.
7. A class should have only one reason to change. (如果不能整理成一个理由去改变一个类，那就说明设计有问题)
8. Don't call us, we'll call you.(低阶的接口不应该调用高阶的接口)

面向对象的设计模式：  
1.  **Strategy Pattern:**   
    defines a family of algorithms, encapsulates each one, and make them interchangeable. Strategy lets the algorithm vary
independently from clients that use it.  
    在现实过程中，动态地切换不同的算法。只要这些算法都继承自同一个接口（后面这句是废话）。
    
2.  **Observer Pattern:**
    defines a one-to-many dependency between objects so that when one object changes states, all its dependents are notified
and updated automatically.
    重点在 one-to-many。每个观察者在初始化之时便将自身注册到对象之中，在感兴趣的状态发生变化时，由被观察对象通知观察者。
    
3.  **Decorator Pattern:**
    Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for 
extending functionality.
    在设计初衷，便决定了对象要继承并修改某一功能。同时，构造方法要有限制，进而确保功能会被成功地现实并修改。
    
4.  **Factory Pattern:**
    ...(这个先等等)
   
5.  **Singleton Pattern:**
    Ensure a class only has one instance and provide a global point of access to it.
    关注点应该是具体的 实现方式。立即初始化 VS 延迟初始化，以及 枚举。优先选择立即初始化。
    
6.  **Command Pattern:**
    Encapsulates a request as an object, thereby letting you parameterize clients with different request,
queue or log requests, and support undoable operation.
   就是把一堆的步骤做个封装，稍微高级点的话还可以加个 undo 的功能，然后对外提供一个调用的接口。
    最好的例子是周五晚上固定的一套动作：开灯，开冰箱，拿啤酒，开电脑，看电影--这个是on，off的话就反着来
   
7.  **Adapter Pattern:**
    Converts the interfaces of a class into another interface clients expect. Lets classes work together that
couldn't otherwise because of incompatible interfaces.
    这个没什么好说的，把不能修改的接口做一个简单的桥接，转换成可以调用的接口。
    
8.  **Facade Pattern:**
    Provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface
that makes the subsystem easier to use.
    注意最后一句：easier to use. 这模式叫 外观模式，将一堆难用的接口封装成一个 高阶 的接口，供外部直接调用。与 命令行模式 有点儿类似
    
9.  **Iterator Pattern:**
    Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
   这个真的没什么好说的...
    
10. **Composite Pattern:**
    Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects
and compositions of objects uniformly.
    重点是 part-whole hierarchies, 可以简单地理解为子类对象也包含相同等级的对象。最直观的就是 树 这个数据结构了。
    菜单可以有子菜单之类的～
    
11. **State Pattern:**
    Allow an object to alter its behaviour when its internal state changes. The object will appear to change its class.
    这东西倒是可以看成固定的模版，在内部状态有变化时，给处不同的反馈。转化下思想，给对象一个状态的变量，由这个具体的变量去决定不同的操作。
    思想转变体现在，身为状态的变量拥有对象本身，可以在发生变化时，动态更新对象内部的状态变量。

12. **Template Method Pattern:**
    Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
    定义一套算法的骨架，由具体调用者去决定其中的某几个步骤的具体实现。
    咖啡和茶的做法是类似的，定义成骨架的话，差别就成了加牛奶和加柠檬的区别了。-- 咖啡可以加柠檬吗？为什么不行？
    
13. **Proxy Pattern:**
    Provide a surrogate or placeholder for another object to control access to it.
    这里只讨论静态代理。代理类实现同样的接口，但是内部要有目标对象。在具体执行某个被代理的方法之前，加入一些逻辑。
    最简单的是：查询数据库查询对象时，如果不拿返回的对象去做一些操作，就不真正地去执行sql。
    InvocationHandler, and Proxy.newProxyInstance, 再强制转换成目标对象。done～
```
Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
```
    




























