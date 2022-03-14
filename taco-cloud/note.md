### start at March 6, 2022

#### 总算开始了，每天都写一点的话，应该可以在这个月底把这本书的基础完整地走一遍。
先从 @SpringBootApplication 开始


#### date March 8, 2022
@SessionAttributes(value), 的有效时间
@ModelAttribute 的执行顺序
@Valid 的作用及错误处理
org.springframework.core.convert.converter.Converter 是如何起作用的？


#### date March 13, 2022 (还行，这次只间隔了5天～)
#### date March 14, 2022 (好吧，昨天也不知道发生了什么事情)
-- 从 Spring 提供的 JPA开始，JDBCTemplate 先不管
* 引入 h2 的数据库。之后在 resources 中添加 schema.sql  和 data.sql，SpringBoot 会在启动的时候自动加载这两个sql文件。
  而配置文件里面的内容。
  generate-unique-name: false ::: tell Spring not to generate a unique random value for the database name.
  name: tacocloud ::: set the database name to tacocloud. which means the JDBCUrl would be: jdbc:h2:mem:tacocloud
  
for @Table in SpringFramework, the table name would be like this: TacoOrder -- taco_order
  @Table("taco_order") just fine~  
for the column, the default converter is: deliveryName -- delivery_name
  @Column("delivery_name") just the same.

对于 CrudRepository，内置了许多有关 CRUD 的方法，一些自定义的有语义的方法实际上也相当有用，比如
  findByDeliveryToAndDeliveryCityAllIgnoresCase(String city);  
不过，这些多半记不住，记住 @Query 这个可以写sql的方法就好了～～～

----------------- 先暂停下，搞 JPA 的东西一直有问题，今晚就把 JPA 的彻底搞明白吧～
-- 应该有半个小时了吧？东西太多了，把该记住的先记了就行，比如原生的 query 和 表名与字段 间的映射关系。
```
  // 原生query：org.springframework.data.jpa.repository.Query
  @Query(value = "SELECT * from tack_order WHERE delivery_city='Seattle'", nativeQuery = true) 
  List<TacoOrder> readOrdersDeliveredInSeattle();
  
  @En
```
