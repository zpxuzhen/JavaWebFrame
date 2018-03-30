package dev.local.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by xz on 2018-3-27.
 */

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByUsernameLike(@Param("username") String username);
    List<User> findByUsername(@Param("username") String username);
    List<User> findByAddress_Name(@Param("addressName") String addressName);

    @Query("{  'username': { '$regex': ?0} }")
    List<User> searchUsers( @Param("username") String username);
}
/**
 *
 * 访问方式:  域名:端口/URI
 * 其中URI就是我们用@RepositoryRestResource声明的users
 * 所以我们的访问地址就是 http://localhost:8080/users
 * 其实@RepositoryRestResource可以省略,这样spring就默认用users作为URI
 * spring的默认命名方式是单词的复数形式,比如user复数就是users
 * 换成child就是children,很神奇.
 *
 */
/***
 * 当我们访问http://localhost:8080/users时会看到不止返回了
 * _embedded我们存在数据库中的内容,还返回了_links表示我们可以怎样访问的链接
 * 甚至page中包含了关于分页的信息.支持直接分页访问.
 * 其中有这样一个链接 http://localhost:8080/profile/users
 * 我们get访问之后返回了descriptors表示user对象的属性
 * create-users创建对象(POST),update-user修改对象(PUT),
 * delete-user删除对象(DELETE),patch-user也是修改对象(PATCH),不太了解这种方式,
 * 还有get-user查询对象(GET),以及get-users分页查询,支持传入page,size,sort
 * 这些所有的增删改查Spring都自动完成了,我们只需要写一个接口即可.
 * 这边是spring的"习惯优于配置" 和 REST风格的完美结合.
 *
 */
/***
 * 增加需求
 * 1.按照username实现模糊查询
 * 只需要增加一个函数声明
 * List<User> findByUsernameLike(@Param("username") String username);
 * 访问:  http://localhost:8080/users/search/findByUsernameLike?username=xiao
 * 2.按照username实现精确查询
 * 只需要增加一个函数声明
 * List<User> findByUsername(@Param("username") String username);
 * 访问:  http://localhost:8080/users/search/findByUsername?username=xiaohong
 * 也就是把Like去掉,不需要改其他任何代码,只是修改函数名.
 *
 * 为什么呢？这就是Spring的 Convention over configuration，命名是有讲究的:
 * Spring提供了一套可以通过命名规则进行查询构建的机制。
 * 这套机制会把方法名首先过滤一些关键字，
 * 比如 find…By, read…By, query…By, count…By 和 get…By 。
 * 系统会根据关键字将命名解析成2个子语句，第一个 By 是区分这两个子语句的关键词。
 * 这个 By 之前的子语句是查询子语句（指明返回要查询的对象），后面的部分是条件子语句。
 * 如果直接就是 findBy… 返回的就是定义Respository时指定的领域对象集合(本例中的List<User>)。
 *
 */

/***
 * 嵌套对象的查询怎么搞？
 * 每个用户都有一个地址,我们新增一个Address对象,并在user中增加Address属性
 * 需求:查询地址相同的所有用户的列表
 * 增加一个函数声明 List<User> findByAddress_Name(@Param("addressName") String addressName);
 * 我们先通过post或者put方式构造一些数据
 * 然后通过 http://localhost:8080/users/search/findByAddress_Name?addressName=beijing 访问
 * 函数名findByAddress_Name是怎么解析的呢?
 * find之后是By说明返回List<User> ,By之后是查询条件Address属性,这个属性是一个对象,然后再去看Address中
 * 是否有Name属性.我们这里Address_Name之间有个下划线,这是为了防止与AddressName混淆,假如User中有个属性叫做
 * AddressName则会发生混乱,到底是Address里的Name还是User中得AddressName,当然spring会优先匹配User中的属性.
 *
 */

/**
 * 再复杂一些行不行？
 * 当然，还有其他操作符：Between (值在两者之间), LessThan (小于), GreaterThan （大于）,
 * Like （包含）, IgnoreCase （b忽略大小写）, AllIgnoreCase （对于多个参数全部忽略大小写）,
 * OrderBy （引导排序子语句）, Asc （升序，仅在 OrderBy 后有效） 和 Desc （降序，仅在 OrderBy 后有效）。
 * 刚刚我们谈到的都是对于查询条件子语句的构建，其实在 By 之前，对于要查询的对象也可以有限定的修饰词 Distinct （去重，如有重复取一个值）。
 * 比如有可能返回的结果有重复的记录，可以使用 findDistinctTodoByUserIdAndDescLike。
 *
 */

/**
 * 我可以直接写查询语句吗？
 * 采用这种方式不用按照命名规则起方法名,比如:
 @Query("{  'username': { '$regex': ?0} }")
 List<User> searchUsers( @Param("username") String username);
 * 1. ?0 是参数的占位符，?0 表示第一个参数
 * 2. MongoDB中没有关系型数据库的Like关键字，需要以正则表达式的方式达成类似的功能。
 */
