## date 28 JULY

MySQL的索引类型:
normal: 普通索引，不知道什么合适的时候就选它
unique: 唯一索引，不重复的列，PrimaryKey 就很合适
fulltext: 全文索引，长文章才用到它
spatial: 空间索引。没什么用，在空间数据类型的字段建立起来的索引，此时的存储引擎为 MYISAM。

B+tree 与 Hash：
B+tree：索引值为范围时，选它
Hash：索引值不是数值时，选它