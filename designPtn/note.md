# Oct14，2023
ok, another passion of three minutes~

the goal of this note is finish the summary of redis within a week,
which is Oct14~Oct21
reference [document](https://redis.io/docs/data-types/)
* 当 redis 服务器 与 客户端 建立连接之后，服务端接受数据包的过程分为两步：
  * 等待数据通过网络发送到 redis服务器；当数据到达时将数据复制到内核的缓冲区
  * 将位于内核缓冲区的数据复制到程序缓冲区中，即内核态与用户态的切换


### Oct19，這週就先把 redis 的基礎知識點都做個總結，能夠發博客的那種。截止日期：Oct 23
一是 redis 的基礎數據結構，當然也要包括實現方式，比如跳表，bite 之類的
二是 redis 常見的面試題，這個大概過一下就行
三是 redis 分布式鎖的實現方式，特別是大神間的爭論，這個一定要花時間看下原文
最後，還有精力的話就把 spring 的實現方式用代碼的形式完整地寫個參考文檔：拿來即可用的那種～