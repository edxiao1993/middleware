# date 23-May 2021

start the redis-server in MacOS:
    cd /path/to/redis-server
    redis-server /path/to/redis.conf

### date 27-May
分布式锁的原理大概是这样子的：
  简单版：尝试存储一个为当前时间戳的值到Redis中，如果能够正确地存到Redis中，则继续余下的操作——CRUD之类。
          如果存储失败，则说明当前有另一个线程在操作该 CRUD，此时应该停止相关的操作。休息一段时间后再进行 CRUD。
          在存储时间戳到 Redis 的基础上，可以存储成功后再判断下存储的值是否与当前传如的值一样。
            有点类似 单例 的双重加锁。有点鸡肋～
  Redisson版：需要添加额外的 Jar 包；并且 Redisson 还需要额外的配置，如 Redis 服务器地址与密码之类的。
               伪代码如下：
```
RLock lock = redissonClient.getLock("productId::" + productId);
try{
    // try to lock this product
    lock.tryLock(60, 20, TimeUnit.SECONDS);
    // TODO: operate this product
} catch (e){
} finally {
    lock.unlock();
}
```

### date 22-July
今天早上的面试，好像可以用一团糟来形容呢～面试官的很多问题我都不知道他在问什么……
是我太年轻了吗？还是说，我根本就不想深入了解相关技术的实现原理：会用就行了，为什么要花时间去了解它们的实现原理呢？
有时间的话，看书看电影喝咖啡不好吗？嗯，这是个问题……
BTW，我是17年毕业的！——说实话，我也不相信17年毕业的人会被几个问题就问倒了，绝对是意外。是的，绝对是意外！！！

##### 以下内容摘抄自：Redis 4.x Cookbook
* chapter one: single thread , non-blocking I/O model to process requests rapidly.
  multiplexing process: Socket Request -> I/O Multiplexing Module -> Event Loop -> Event Handler
  非阻塞 I/O
  Redis Protocol: REdis Serialization Protocol(RESP)
  
* chapter two Data Type:
** String: 
    1. set value, get value, get the length of value by key, append the value by key, 
    2. check if the key is existed before set a value, multiple set key and value.
    * there are three encodings to store string objects:
      1. int: for strings representing 64-bit signed integers
      2. embstr: for strings whose length is less or equals 44 bytes
      3. raw: for strings whose length is greater than 44 bytes
** List: can be used as a stack or queue. double linked list
    1. push the data into a list at LEFT: LPUSH [key] [value, value, value, ...]
    2. get all the value from a key,  
    3. insert a value to the right end.
    4. insert a value after a specific value.
    5. get the value at specific position
    6. pop at Left or Right, and Blocking Version with timeout parameter
** Hash: represents mapping relationships between fields and values. maximum number of fields is 2^32 - 1
    1. set a hash data type: HMSET "kyoto ramen" "address" "801 Mission st, San Jose, CA" "phone" "123-456" "rating" "5.0"
      note: the hash data object's key is "kyoto ramen", and the fields is "addres", "phone", "rating"
    2. get a specific field in Hash: HMGET "kyoto ramen" "rating"
    3. check if the field in Hash is existed
    4. get all the fields and values in Hash
    5. set/delete a single field in Hash
    6. set before checking
** SCAN operation
** Set: a colletion of unique and unordered objects. maximum number of elements is 2^23 - 1
    1. set a set data type: SADD "Oroginal Buffalo Wings" "one" "two" "three"
    2. test an element is in the set, remove an element in set, get the number of set
    3. get all the elements of Set
    * there are two encodings internally to store set objects:
      1. intset: for sets in which all elements are intergers
      2. hashtable
** SortedSet: each element in this kind of set owns a weight that can be used for sorting.
    1. voting rate and the name of each restaurant: ZADD ranking:restaurants 100 "Olive" 23 "PF" 34 "steakhouse" 45 "red"
    2. retrieve this ranking, increse the voting to the specific restaurant,
    3. browse the ranking and the number of votings for specific restaurant.
    4. combine 
    * there are two encodings internally to store sorted set objects:
      1. ziplist: for a sorted set whose length is less than zset-max-ziplist-entries(default is 128)
                    and the size of every element is the set is less than zset-max-ziplist-value(default is 64 bytes) in configuration
      2. skiplist: the default encoding when ziplist encoding cannot be used per configuration.
** hyperloglog: optimize the memory and the performance issues caused by the set.
    1. add the user is at specific restaurant: PFADD "Counting:Olive Garden" "000123"
       PFADD "Counting:Olive Garden" "000456"
    2. retrieve how many distinct visitors there are for this restaurant with PFCOUNT command: PFCOUNT "counting:Olive Garden"
    * using a fixed memory(less than 12 kb for up to 2^64 cardinalities) and constant time complexity(O(1) per key).
    * a standard error of less than 1%
** GeoData: stored as a sorted set 
** Key Manager

* chapter three:
** BitMap: save enormous memory space for storing boolean information under certain circumstances.
    1. set the bit value in a bitmap at specified offset: SETBIT "user_tried_reservation" 100 1
    2. retrieve the bit value at specified offset, count the 1 value in bitmap
    3. AND, OR, XOR, NOT to perform bitwise operations between bitmaps.
** expiration on keys:
    1. the expiration time for the key will be stored as an absolute UNIX timestamp. even the Reids server is down, the timestamop won't be lost.
    2. when a key is expired and the client tries to access it, Redis will delete the key from memory immediately.
    3. picks 20 keys associated with the timeout, the expired keys will be deleted immediately. if more than 25% of the selected keys have expired, try again. --- 10 times per seconds 
** sort:
    1. nothing special ......
** pipeline: the client bundles multiple commands and sends them in one shot, instead of waiting for the execution result of each individual command,
       it asks the server to return the results after all commands have been executed,
** transaction in Spring?
    1. the first one is a syntax error for a command. In this case, because the rror is detected while queuing the commands, 
       the entire transaction will fast-fail and none of the commands in this transaction will be processed(NOTE: in queue)
    2. another case is when, although all commands have been queued successfully, the error occurs in the middle of execution.
       other commands afterward will continue to execute without a rollback.(continuely execute with a roll back!!!)
** PubSub(publish-subscribe):
    1. 
       

