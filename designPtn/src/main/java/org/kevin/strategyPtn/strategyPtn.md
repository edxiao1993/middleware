### start at October 30 - 2021

策略模式：  
  defines a family of algorithms, encapsulates each one, and makes them interchangeable. 
  Strategy lets the algorithm vary independently from clients that use it.  
简单地说，就是定义算法簇，在程序运行地时候允许动态地更改对象地行为与状态。  
现实的例子，就是根据会员等级的不同提供不同的打折优惠。

Has-a 怎么都要比 Is-a 要好。  
但最重要的是，在程序设计的一开始，就把变与不变的 行为 与 状态 区分出来。再决定采用 继承（Is-a） 还是 组合（Has-a）  
算法簇的定义其实也好理解，也完美地体现了面向接口变成的 设计原则。


#### date November 1
稍微复习下策略模式：说白了就是应用了两个面向对象的设计原则：
1。面向接口编程
2。组合优于继承