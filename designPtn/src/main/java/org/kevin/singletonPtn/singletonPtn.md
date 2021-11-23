### start at November 23, 2021

单例模式：Ensure a class only has one instance and provide a global point of access to it.
呃，就实现方式来说，它是最简单的设计模式了。
而且常见的集中设计模式我也都会，懒汉饿汉枚举什么的。

双重锁检查似乎没有写的必要，因为多线程的那种书这是很愚蠢的做法。
  以现代机器的性能而言，也不需要考虑初始化时耗费的时间……好像有点道理。
稍微记录下吧。