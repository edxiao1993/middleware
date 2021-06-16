# date 23-May 2021

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

