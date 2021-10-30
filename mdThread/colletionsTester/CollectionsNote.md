## date 26-JULY

存储元素到 HashXxx 的集合中，必须确保 hashCode 与 equals 的重写，否则无法保证元素唯一。
HashMap 计算 hash 的方式：(key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)
    将元素的 hash 值，与其本身的无符号右移 16 位作异或运算。据说可以让 hash 后的结果更加均匀，减少 hash 碰撞。
    --- 它说是就是吧～

Collection:
  - List:
    - LinkedList: 底层数据结构是链表，查询慢，增删快。双端队列，addFirst, addLast, getFirst, getLast
                  内部实现是一个Node：元素本身，指向前一个元素，指向后一个元素
    - ArrayList: 底层数据结构是数组，查询快，增删慢。
                 初始化的默认大小是10。扩容方式是增加原大小的 50% 
    - Vector: 线程安全～
  - Set:
    - HashSet: 底层实现是 HashMap。尽管元素不重复，但这种不重复是建立在 hashCode 与 equals 均返回 false 的前提下的。
               如果 hashCode 相等，但 equals 返回 false，则在该位置添加一个链表的节点。具体参照 HashMap
      - LinkedHashSet: 底层数据结构采用链表和哈希表共同实现，链表保证了元素的顺序与存储顺序一致。
                       jdk11 的源码好像并没有看到 链表？？？ --- 具体的实现方式是 LinkedHashMap……
                       默认大小是 16，扩展因子是 0.75
    - TreeSet: 底层实现是 TreeMap......

Map: 提供三种集合的视图，分别是 Key 集合(keySet())，Value 集合(values())，Key-Value 集合(entrySet())
  - HashTable: 
  - HashMap: 底层实现是一个 Node<K, V>，默认 size 是 16(大小永远是 2 的平方), 默认负载因子是 0.75。hashMap 初始化的最大大小是 2^30，本身的最大大小是 Integer.MAX
            如果初始化大小，那么 HashMap 会将该值转为比原值大的 2 的平方。
            put 一个元组到 HashMap 中，先计算 Hash 值，然后与 Hash 执行 & 操作，确定元组存放位置 --- 此时的实现方式是数组，假如没有产生哈希碰撞的话
                如果产生哈希碰撞，则采用链表的方式存储元组。换句话说，组成数组本身的元素，就是一个单向链表，能指向下一个可能存在的元素
                当产生哈希碰撞，且链表的长度大于8时，转为红黑树存储(此时Map的大小至少要有64，否则先进行扩容)
            resize 的过程：当前 Map 的大小达到 capacity * load factor 时，进行扩容 --- 原大小 * 2
    - LinkedHashMap
    - WeakHashMap
  - TreeMap: 底层实现是一个 Entry<K, V>, 不再有 Node 了。比较也只是根据 Key 进行，在初始化时还可以指定 comparator。
            可以实现 value 的某个字段排序吗？--- 不借助其他数据结构的话，不行
  - IdentifyHashMap