# springDemo1
spring基础，包含bean装配，scope作用域，spring表达式，spring生命周期，注解配置等

#简介
什么是：Spring

Spring是一个分层的JavaSE/EE full-stack(一站式) 轻量级开源框架。
轻量级：依赖其他内容教小，使用资源消耗也少。
核心：控制反转Ioc和面向切面AOP。
spring生成的东西叫做bean.
##体系结构
核心组件：beans、core、context、expression

##第一个实例
loc控制反转
1、导入jar包
2、spring核心配置文件
3、使用api获得对象实例


##DI依赖注入
一个类中使用了另一个类，就称为两个类存在依赖关系。从spring获得service实现类（ioc),spring自动将dao的实现类注入给service。

service提供setter方法。

BeanFactory和ApplicationContext

采用延迟加载，当第一次调用getBean方法时初始化，Application在加载完成配置文件之后进行初始化。

##装配bean基于xml

bean的三种实例化方式

1、使用默认构造
<bean id="" class="" ></bean>


	<!-- 创建dao -->
	<bean id="bookDaoId"  class="cn.tf.demo2.BookDaoImpl"></bean>
	<!-- 创建service -->
	<bean id="bookServiceId"  class="cn.tf.demo2.BookServiceImpl">
		<!-- 使用property来完成注入,name表示当前属性名称，ref表示配置文件中另一个bean的引用 -->
		<property name="bookDao" ref="bookDaoId"></property>
	</bean>


2、静态工厂
    public class MyFactory {
    	
    	public static PersonDao  createPersonDao(){
    		return new PersonDaoImpl();	
    	}
    }

配置文件中：

    <bean id="personDaoId"   class="cn.tf.demo4.MyFactory"  factory-method="createPersonDao"></bean>

3、实例工厂
使用工厂之前需要先创建

	//实例工厂
	public PersonDao  createPersonDao(){
		return new PersonDaoImpl();	
	}

配置文件：

	<bean id="myFactory" class="cn.tf.demo4.MyFactory"  >
	</bean>
	
	<bean id="personDaoId" factory-bean="myFactory"  factory-method="createPersonDao"></bean>


###bean的种类

普通bean:之前使用的所有bean，一般很常用，例如service和dao等

工厂bean：spring提供接口，FactoryBean,一个特殊的bean，具有Factory工厂，用于生产特定的Bean的bean。例如：ProxyFactoryBean用于生产代理对象的一个bean。


id属性和name属性：

id可以自动提示，名称不能重复。
name如果没有配置id，name也可以使用，可以编写多个名称，使用逗号分隔。

###bean的作用域
spring默认情况下创建的bean都是单例的。

<bean id=""  class=""  scope="" >

取值：
singleton:单例。
prototype:多例。


###bean的生命周期

1. 初始化
2. setter 属性注入
3. 获得配置bean名称：replyDaoId，必须实现接口：BeanNameAware
4. 获得spring容器，相当于TestApp new ClassPath... , 必须实现接口：ApplicationContextAware
--- 也可以实现接口：BeanFactoryAware
5. 初始化之前执行
6. 初始化前属性设置
7. 初始化方法，需要在xml配置 <bean init-method='' >
8. 初始化之后执行
9. save 方法

-

	<bean id="replyDaoId" class="cn.tf.demo6.ReplyDao"  
		init-method="replyInit"
		destroy-method="replyDestory">
		<property name="username"  value="张三"></property>
	</bean>
	
	<!-- 配置后处理bean -->
	<bean  class="cn.tf.demo6.MyBeanPostProcessor"></bean>


###依赖注入
手工装配：使用xml：1、构造方法注入；2、setter方法注入；3、接口注入


	<bean id="categoryId" class="cn.tf.demo7.a.Category">
		<!-- 描述构造方法的一个参数
			index:参数的索引
			type:参数的类型
			value:参数的值
			ref:参数的值的引用对象
		 -->		
		<constructor-arg index="0" type="java.lang.String" value="123"></constructor-arg>
		<constructor-arg index="1" type="java.lang.Integer" value="456"></constructor-arg>
	</bean>





自动装配：框架整合时:

	byType：按类型装配 
	byName：按名称装配
	constructor按构造
	auto 不确定装配。


###p命名空间
简化set方法注入

setter方法：

    <bean id="" class="" >
	<property name="username" value="make" >
	<property name="address" ref="addressId" >

p命名空间：

 xmlns:p="http://www.springframework.org/schema/p"



	<bean id="companyId" class="cn.tf.demo7.b.Company"  p:name="指令汇科技"  p:address-ref="addressId"></bean>
	<bean id="addressId"  class="cn.tf.demo7.b.Address"  p:addr="湖南衡阳"></bean>
	

###SpEL表达式
spring表达式语言。

value="#{表达式}"


	<bean id="studentId" class="cn.tf.demo7.c.Student">
			<property name="teacher"  value="#{teacherId}"></property>
			<property name="pi"  value="#{T(java.lang.Math).PI}"></property>
	</bean>
	
	<bean id="teacherId"  class="cn.tf.demo7.c.Teacher"  >
			<property name="tname"  value="#{'abc'.toUpperCase()}"></property>
	</bean>


###集合注入
常见的5种集合：

    private String[] arrayData;
	private List<String> listData;
	private Set<String> setData;
	private Map<String,String> mapData;
	private Properties propsData;

配置文件中：

    <bean id="collbeanId" class="cn.tf.demo7.d.CollBean">
		<!-- 数组 -->
		<property name="arrayData">
			<array>
				<value>数组1</value>
				<value>数组2</value>
				<value>数组3</value>
			</array>
		</property>
		<!-- List集合 -->
		<property name="listData">
			<list>
				<value>List集合1</value>
				<value>List集合1</value>
				<value>List集合1</value>
			</list>
		</property>
		
		<!-- Set集合 -->
		<property name="setData">
			<set>
				<value>set集合1</value>
				<value>set集合2</value>
				<value>set集合3</value>
			</set>
		</property>
		
		<!-- map集合 -->
		<property name="mapData">
			<map>
				<entry  key="aa"  value="00"></entry>
				<entry>
					<key><value>bb</value></key>
					<value>11</value>
				</entry>
			</map>
		</property>
		
		<!-- properties对象 -->
		<property name="propsData">
			<props>
				<prop key="aa">00</prop>
				<prop key="bb">11</prop>
			</props>
		</property>
	</bean>



##装配bean基于注解
使用注解类用于取代xml配置文件，优点在于：xml配置少，使用注解配置信息简化。不足之处在于硬编码。

@Component组件，用于取代<bean id="" class="" >
    
    @Component(value = "orderDaoId")

@Repository 修饰dao层

@Service 修饰service层

Controller 修饰web层


方案1：

	@AutoWired 自动注入，默认按照类型
		可以修饰在字段上
		也可以修饰在setter方法上
		缺点：如果同一个接口，有两个实现类，就会存在冲突

	@Qualifier 修改AutoWired匹配，将按照名称匹配。

方案2：

@Resource 可以完成 @AutoWired 和 @Qualifier 功能
		例如：@Resource("userDaoId") 按照名称匹配

	 @PostConstruct 初始化
	 @PreDestroy 销毁

@Scope 作用域

使用注解，必须将“被注解修饰的类”交予spring进行扫描。

	<context:component-scan base-package="类所在包名">



##整合junit
导入spring-test-4.2.5.RELEASE.jar

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations="classpath:cn/tf/demo9/beans.xml")
    public class TestApp {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void test1(){
		userDao.save();	
	}


在classpath中加载注解文件


###xml和注解混搭使用

	<!-- 使 注入的注解可以使用 -->
	 <context:annotation-config></context:annotation-config>
	
	<!-- 所有的bean都在xml配置 
		所有的依赖都是注解
	-->
	<bean id="userDaoId" class="cn.tf.demo10.UserDaoImpl"></bean>
	<bean id="userServiceId" class="cn.tf.demo10.UserServiceImpl"></bean>
	<bean id="userActionId" class="cn.tf.demo10.UserAction"></bean>













