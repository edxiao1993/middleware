## date 24-JULY

### Part One
#### chapter 1:
安全性：永远不发生糟糕的事情
活跃性：某件正确的事情最终会发生
性能问题：频繁出现上下文切换操作（Context Switch）会带来极大的开销


### chapter 2：
要编写线程安全的代码，其核心在于要对状态访问操作进行管理，特别是对共享的(shared)和可变的(mutable)状态的访问
  共享：变量可以由多个线程同时访问
  可变：变量的值在其生命周期内可以发生变化
线程安全性的正确性：某个类的行为与其规范完全一致。在良好的规范中通常会定义各种不变性条件（Invariant）来约束对象的状态，
    以及定义各种后验条件来描述对象操作的结果
原子性
竞态条件：

```
  if(intance == null){
    instance = new ExpensiveObject();
  }
```
复合操作
2.3 加锁机制：要保持状态的一致性，需要在单个原子操作中更新所有相关的状态变量。
内置锁：synchronized(...){}
重入：某个线程试图获得一个已经由它自己持有的锁，那么这个请求就会成功
     重入意味着获取锁的粒度是"线程"，而不是"调用"
原子性与复合操作：尽管单个操作是原子性，但如果要把多个操作合并为一个复合操作，就需要额外的加锁机制


### chapter 3:
可见行：为确保多个线程之间对内存写入操作的可见性，必须使用同步机制
加锁与可见性：加锁的含义不仅仅局限与互斥行为，还包括内存可见性。为了确保所有线程都能看到共享变量的最新值，
    所有执行读操作或者写操作的线程都必须在**同一个锁上**同步
volatile 变量：1. 对变量的写入操作不依赖变量的当前值，或者能确保只有单个线程更新变量的值
              2. 该变量不会与其他状态变量一起纳入不变性条件中
              3. 在访问变量时不需要加锁

发布与逸出：
  发布(Publish)：使对象能够在当前作用域之外的代码中使用
  逸出(Escape): 某个不应该被发布的对象被发布

线程封闭：不共享数据，仅在线程内访问数据
  栈封闭：将对象数据转换为局部变量
  ThreadLocal: 将线程中某个值与保存值的对象关联起来。假如在线程中往ThreadLocal设置了某个变量，那么随后该线程对变量的操作都只与该线程有关。
不可变性：不可变对象一定是线程安全的。只有一种状态，并且只由构造函数控制


### chapter 4:
设计线程安全类的三个要素：
  1. 找出构成对象状态的素有变量
  2. 找出约束状态变量的不变性条件
  3. 建立对象状态的并发访问管理策略
同步策略。。。
依赖状态


### chapter 5:
委托是创建线程安全类的一个最有效的策略：只需让现有的线程安全类管理所有的状态即可
同步容器类：Collections.synchronizedXxx
  : 分段锁
HashMap -> ConcurrentHashMap
SortedMap -> ConcurrentSkipListMap
SortedSet -> concurrentSkipListSet
List -> CopyOnWriteArraylist
Set -> CopyOnWriteArraySet

阻塞队列与生产者-消费者：消除了生产者类和消费者类之间的代码依赖性；
    将生产数据的过程与使用数据的过程解耦，以简化工作负载的管理。（Executor任务执行框架）
    NOTE：共享工作队列
BlockingQueue的实现：
    LinkedBlockingQueue, ArrayBlockingQueue, PriorityBlockingQueue, SynchronousQueue(没有存储功能，因此put和take会一直阻塞)
双端队列与工作密取：
    在生产者-消费者模式中，所有消费者都有一个共享的工作队列；而在工作密取中，每个消费者都有各自的双端队列；
        当完成自己的全部工作时，可以从其他消费者的双端队列末尾秘密获取工作

同步工具类：不仅能作为容器保存对象，还能协调生产者和消费者线程之间的控制流；
    - 信号量(Semaphore)，栅栏(Barrier)，闭锁(Latch)
闭锁：确保某些活动直到其他活动都完成后才继续执行。
FutureTask: 
信号量(Semaphore): 控制同时访问某个特定资源的操作数量，或者同时执行某个指定操作的数量。
栅栏：阻塞一组线程直到某个时间发生；所有线程都必须同时到达栅栏为止，才能继续执行。
  通常将一个问题拆分成一系列相互独立的子问题。

### Summary of Part One:
可变状态是至关重要的：所有的并发问题都可以归结为如何协调对并发状态的访问。可变状态越少，就越容易确保线程安全性。
尽量将域生命为 final，除非需要它们是可变的。
不可变对象一定是线程安全的。
封装有助于管理复杂性。
用锁来保护每个可变变量。
当保护同一个不变性条件中的所有变量时，要使用同一个锁。
在执行复合操作期间，要持有锁。
不要故作聪明地推断出不需要使用同步。
在设计过程中考虑线程安全，或者在文档中明确地指出它不是线程安全的。
将同步策略文档化。


### chapter 6:

无限制创建线程的不足：

1. 线程生命周期的开销非常高
2. 资源消耗：活跃的线程会消耗系统资源，特别是内存。如果可运行的线程数量多于可用处理器的数量，有些线程就必须被闲置。
3. 稳定性：

Executor framework：提供一种标准的方法，将任务的提交过程与执行过程解藕开来，并用 Runnable 来表示任务。

执行策略：（在部署阶段即选择与可用硬件资源最匹配的执行策略）

* 在什么线程中执行任务？what
* 任务按照什么顺序执行？what，FIFO、LIFO、Priority
* 有多少个任务能并发执行？how many
* 在队列中有多少个任务在等待执行？how many
* 如果系统由于过载而需要拒绝一个任务，应该选择哪一个？如果通知应用程序有任务被拒绝？which，how
* 在执行一个任务之前或之后，应该进行哪些动作？what

Executors中的线程池：

1. newFixedThreadPool
2. newCachedThreadPool
3. newSingleThreadExecutor(FIFO, LIFO, Priority)
4. newScheduledThreadPool

** 为并行找出任务边界 **

Executor执行的任务有四个生命周期阶段：创建、提交、开始、结束。
 
Future: 表示一个任务的生命周期，并提供了相应的方法来判断是否已经完成或取消，以及获取任务的结果和取消任务等。
    为 future.get() 设置时限：future.get(timeLeft, TimeUnit);
``` 
future.get(); // 会一直阻塞到任务完成。
/** 
 * 如果任务抛出了异常，那么 get 将该异常封装为 ExecutionException 并重新抛出。
 * 如果任务被取消，get 将抛出 CancellationExceotion。
*/
```
ExecutorService 中的 submit 方法会返回一个 Future，从而将一个 Runnable 或 Callable 提交给 Executor
Summary: 通过围绕任务执行来设计应用程序，可以简化开发过程，并有助于实现并发。
*** 必须定义清晰的任务边界。


### chapter 8:
在任务与执行策略之间的隐性耦合：
1. 依赖性任务：如果提交给线程池的任务需要依赖其他的任务，那么就隐含地给执行策略带来约束。必须小心地维持这些执行策略以避免产生活跃性问题
2. 使用线程封闭机制的任务：
3. 对响应事件敏感的任务
4. 使用ThreadLocal的任务：只有当线程本地值的生命周期受限于任务的生命周期，在线程池的线程中使用 ThreadLocal 才有意义。

```
public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue<Runnable> workQueue,
                          ThreadFactory threadFactory,
                          RejectedExecutionHandler handler) { ...}
```

线程工厂：每当线程池需要创建一个线程时，都是通过线程工厂方法来完成的。
        默认的线程工厂方法创建的线程，是一个新的、非守护的线程，并且不包含特殊的配置信息
```
public class MyThreadFactory implements ThreadFacotry{
    private final String poolName;
    
    public MyThreadFactory(String poolName){
        this.poolName = poolName;
    }
    
    public Thread newThread(Runnable runnable){
        return new MyAppThread(runnable, poolName);
    }
}
```

扩展 ThreadPoolExecutor:


### chapter 10：
1. 确保线程在获取多个锁时采用一致的顺序
2. 开放调用：在调用某个方法时不需要持有锁

### chapter 11:
提升可伸缩性：
1. 减少锁的持有事件
2. 减低锁的粒度
3. 采用非独占锁(ReadWriteLock) 或 非阻塞锁来代替独占锁
