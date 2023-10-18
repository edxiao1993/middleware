### start at March 6, 2022

#### 总算开始了，每天都写一点的话，应该可以在这个月底把这本书的基础完整地走一遍。

先从 @SpringBootApplication 开始

#### date March 8, 2022

@SessionAttributes(value), 的有效时间 @ModelAttribute 的执行顺序 @Valid 的作用及错误处理
org.springframework.core.convert.converter.Converter 是如何起作用的？

#### date March 13, 2022 (还行，这次只间隔了5天～)

#### date March 14, 2022 (好吧，昨天也不知道发生了什么事情)

-- 从 Spring 提供的 JPA开始，JDBCTemplate 先不管

* 引入 h2 的数据库。之后在 resources 中添加 schema.sql 和 data.sql，SpringBoot 会在启动的时候自动加载这两个sql文件。 而配置文件里面的内容。 generate-unique-name:
  false ::: tell Spring not to generate a unique random value for the database name. name: tacocloud ::: set the
  database name to tacocloud. which means the JDBCUrl would be: jdbc:h2:mem:tacocloud

for @Table in SpringFramework, the table name would be like this: TacoOrder -- taco_order @Table("taco_order") just
fine~  
for the column, the default converter is: deliveryName -- delivery_name @Column("delivery_name") just the same.

对于 CrudRepository，内置了许多有关 CRUD 的方法，一些自定义的有语义的方法实际上也相当有用，比如 findByDeliveryToAndDeliveryCityAllIgnoresCase(String city);  
不过，这些多半记不住，记住 @Query 这个可以写sql的方法就好了～～～

----------------- 先暂停下，搞 JPA 的东西一直有问题，今晚就把 JPA 的彻底搞明白吧～ -- 应该有半个小时了吧？东西太多了，把该记住的先记了就行，比如原生的 query 和 表名与字段 间的映射关系。

```
  // 原生query：org.springframework.data.jpa.repository.Query
  @Query(value = "SELECT * from tack_order WHERE delivery_city='Seattle'", nativeQuery = true) 
  List<TacoOrder> readOrdersDeliveredInSeattle();
  
  // javax.persistence.Entity
  @Entity(name="") // 对应的 table_name
  
  @Id // 标识主键，为空时新增，有值时更新
  @GeneratedValue(strategy = GenerationType.AUTO)
  
  // 对应的列名，后一个参数是对应的数据库类型。
  @Column(name = "placed_at", columnDefinition = "timestamp")
```

接下来说说 mybatis

1. 定义好sql之后（这是一般情况下会先做好的事情），利用 mybatis-generator 去生成对应的 entity // 好吧，因为数据库的表其实还没有生成，而是要等到项目启动的时候才去加载……所以这里用不了
   mybatis-generator 先大致写一下吧，反正也不多 -- 或者，导入mysql，再生成？反正sql文件已经有了。。。。。。 // 好吧，mybatis 和 JPA 一起用貌似会报错……
   Summary：JPA大概是清楚了，实现 CrudRepository 之后确实简单了很多很多，对于一些没法直接使用语义的方式去执行的sql，用 @Query 的方式
   也可以很轻松地实现原生的sql。但有一点还不甚明了的是，一对多与多对多的实现是怎么一回事？明天或者这周找个时间再去看看。

### date March 29
page 153：明晚做总结的时候记得加下。
oauth2 的认证登陆，这部分先略过，把这本书学完了再回过头去学学 oauth2 的东西。
page 164: 在 controller 获取登陆的四种方法
note: 写到了这里，程序跑起来应该是会有问题的，所以就不再启动了。
  如果不做总结的话，多半会忘了之前写过的那些东西。比如某个周末花了一下午弄明白的 JPA，就忘得差不多了。哈哈哈～～～  
  明天不管怎么样也要把 security 的东西写个总结出来。不然就别再做下去了！！！

### date April 1
挺有意思的一个jar包：spring-boot-starter-data-rest
@RequestMapping 里，  
  produces="application/json" -> Accept, point to Request output
  consumes="application/json" -> Content-Type, point to Request Input