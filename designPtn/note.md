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

### Oct20, String in redis

#### redis string
大部分情況下，String 類型的數據都是用來充當存儲的工具。至於內容，可以是文本，序列化的對象，二進制數組，甚至是圖片  
而唯一的限制是存儲的大小不能超過 512MB。  
最常用的指令：[這是完整的指令列表](https://redis.io/commands/?group=string)
```
set, get, getset(get old value, the set new value),
incr, incr by, decr, decr by
mset, mget 可以設置/返回多個值
```

#### redis JSON
今天才发现的一个挺有意思的命令，但大部份情况下，用 redis hash 似乎也行得通？在这里稍微记录一下

#### redis lists
Redis lists are linked lists of String value, frequently used to: 
implement stack and queue, or build queue management for background worker systems - thread
稍微多说一句，redis lists 的实现是链表 -- 好吧，这句话已经能让学过数据结构的人在说什么了，所以就停在这里了。
至于内部的实现方式，等后面再细聊～
基础的用法，非阻塞
```
LPUSH, LPOP, LLEN, LMOVE(automatically moves elements from one list to another),
LTRIM(reduces a list to the specified range of elements), LRANGE
```
下面是阻塞式的指令，使用的场景式哪些呢？等待工作队列有数据吗？
```
BLPOP(BRPOP): block until there are a element become available
BLMOVE: atomatically move elements from one list to another. if the source list is empty, the command will block until a 
new element becomes available.
```

* redis 有个比较有意思的点，当首次输入某个指令的 key 不存在时，redis 会优先创建一个对应类型的数据结构，如 lists，或 sets。
* 但假如一个 key 已经有对应类型了，比如 'set myKey myValue'，再执行 LPUSH myKey listValue1，这时 redis 会报错。

redis 本身存储的数据量也是有限制的。相较于 string 类型的最大容量是 512MB，list 最大的数据个数是 2^32 - 1。那么单个的值最大能多少呢？


#### redis sets
Redis sets is an unordered collections of unique strings(members).
```
SADD, SREM, SISMEMBER, SINTER(intersection), SCARD(size of a set), SMEMEBERS(return all members)
```
个数的限制同 lists。
稍微有点要提及，当 set 的值个数很大的时候，SMEMBERS 的时间为 O(n)。一个可代替的指令是 SSCAN - 需要花点时间找找相关资料，根据上次
在公司里同事的某个需求，似乎不是很完美，- TODO

#### redis hashes
Redis hashes are record types structured as collections of field-value pairs. 
存储对象是个非常不错的用法，但也要具体具体情况具体分析。
```
hset hashKey field1 value1 field2 value2 -- 直接通过命令去写确实有点奇怪，
这里的 key 是 hashKey，然后有两个 field：field1，field2，相对应的值是 value1，value2
如果 value 是一串字符串呢？用单括号包起来就行～
```
这里，相较于 lists 与 sets，hash 的 field 的数量也是 2^32-1 
而时间复杂度，有点类似于 sets 或 lists，获取全部数据的情况下是 O(n)。

#### redis sorted sets
加了权重分的 sets。具体操作上有点类似于 hashed，因为它比 sets 多了一个 scores。
排序的规则是从小到大，如下指令，返回的是 Ford, Sam, Norem, Prickett。
当分数一致时，以字母表顺序返回
```
操作的过程有点类似于 hashed：
ZADD racer_scores 10 'Norem' 8 'Sam' 6 'Ford' 14 'Prickett'
```
时间复杂度：大部份操作是 O(log(n)), n 指 zset 的成员数量。
而 ZRANGE 是 O(log(n) + m), m 指返回的数量

#### redis streams
is a data structure that act like an append-only log but also implements several operations to overcome some of the limit
of a typical append-only log.
这里比较有意思的一个点是 streams 也有消费者群组的概念，借鉴于 kafka。
事件流？通知？具体的用法可能要等到具体的场景下才能记得住了，目前知道这个指令的存在即可，后续……也不知道有没有后续～

#### redis geospatial
坐标。主要用于发现附近的点或者 bounding box？- 美团的单车就是绝佳的用法～～～
```
GEOADD, GEOSEARCH
:::
GEOADD bike:rentable -122.27652 37.805186 station:1
GEOADD bike:rantable -122.2674626 37.8062344 station:2

GEOSEARCH bike:rentable FROMLONLAT -122.2612767 37.7936847 BYRADIUS 5 km WITHDIST
-- 这的 '5 km' 是 redis 自己算出来的吗？
完整的指令：：：
GEOSEARCHSTORE destination source <FROMMEMBER member | FROMLONLAT longitude latitude> 
  <BYRADIUS radius <M | KM | FT | MI>
  | BYBOX width height <M | KM | FT | MI>> [ASC | DESC] [COUNT count
  [ANY]] [STOREDIST]
```

#### redis bitmaps
严格意义上来讲，bitmaps 并不是一个数据结果，它的实现仍就是 string，因此 string 的限制也是 bitmaps 的限制
bitmaps 的一个最主要的优势就是它省空间～ redis 给的其中一个例子是：在拥有不同的 id 的 user 存储在 redis 的 bitmaps 中，
如果需要判断 user 是否需要订阅消息（Y｜N）的操作，那么 512MB 可以存储 40亿 的用户数据！
bitmaps 的操作分为两步，一是常数时间的设置为0/1，如 SETBIT，GETBIT  
二是计算一个 groups 下的设置的 bit值
```
SETBIT pings:2023-10-22-00:00 userKevin 1
GETBIT pings:2023-10-22-00:00 userKevin - return 1
GETBIT pings:2023-10-22-00:00 userEdward - return 0

完整的指令如下：
SETBIT key offset value - 这里的 value 值是 0/1
```
操作的时间复杂度：SETBIT GETBIT 是 O(1), 而 BITOP 是 O(n).

#### redis bitfields
Redis bitfields let you set, increment, and get integer values of arbitrary bit length.
These value are stored using binary-encoded Redis Strings. - support atomic read, write, increment operation.
```
BITFIELD player:1:stats SET u32 #0 1000 - return 0
BITFIELD palyer:1:stats INCRBY u32 #0 50 INCRBY u32 #1 1
1)1050
2)1

BITFIELD key [GET encoding offset | [OVERFLOW <WRAP | SAT | FAIL>]
  <SET encoding offset value | INCRBY encoding offset increment>
  [GET encoding offset | [OVERFLOW <WRAP | SAT | FAIL>]
  <SET encoding offset value | INCRBY encoding offset increment>
  ...]]
```

### end of Oct22, data structure of redis 的数据结构大概就这些了
晚上需要把具体的存储方式（？）再详细说说，比如跳表之类的。