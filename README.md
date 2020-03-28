## 重要的todo
- 数据库的非空设置
- model和mapper的非空校验？bingresult什么的
- 异常和事务的回滚，这个非常重要


## 3.24
搞了一个自动机，一开始 spring 官网那个我没看懂，它里面有一个 Builder 我不太清楚是一个类还是一个方法，推测是类似构造器之类的东西。现在没有能力搞懂，所以抄了一个能用的。地址看这里https://blog.csdn.net/gwd1154978352/article/details/79577597

分为这几步：
- 新建两个枚举类。一个是事件 Events，一个是状态 States
- 配置类 StateMachineConfig, 里面写source -> event ->target, 不过他的格式是 **源.目的.事件** source(States.STATE1).target(States.STATE2).event(Events.EVENT1)。但是里面重写了一个方法，里面好多if，官方的做法也是这么多吗？
- controller 里面调用。首先是@Autowired private StateMachine<States, Events> stateMachine;然后stateMachine.start();stateMachine.sendEvent(Events.PAY);stateMachine.sendEvent(Events.RECEIVE);就好了。
今天先到这里。

**todo:** 状态机的配置和应用


## 3.25
1. organizerController中声明了接口
2. 翻阅之前的代码，学习图片和数据怎样传输到后端
3. 学习了InputStream 并打印出来

## 明天：写3个学习记录吧，40分钟写一个。网上抄为主。
pre. 学习了maven知识、npm知识、webpack知识
1. 订单的状态机的
2. 数据库设计的
3. 概要设计

## 3.26凌晨
1. 调通了OSS模块，之前上线的时候设置成了内网地址，所以花了一点时间排查，换成公网地址就好。关键是内网公网地址长的很像，要注意。
2. 批量生成员工账号搞定了。

## 3.26晚上23点
1. 晚上开会，讲了中期检查的事情，我要开始准备了。
2. 调好了电子表格的生成
3. 写了很多service
4. 调整了几个数据表结构

## tips：速度为主，感觉后面来不及了，所以要快点上前端。这段时间主要搞中期检查。4月份要上前端了。

## 3.28
1. 写好了中期检查
2. 调通了es搜索，开始用contains很多搜不到，后来用like都可以隔字搜索了，like牛逼！