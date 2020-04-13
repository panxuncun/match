## 重要的todo
- 数据库的非空设置
- model和mapper的非空校验？bingresult什么的,比如int的参数我传中文进去，直接出错了，返回的200的机会都没有
- 异常和事务的回滚，这个非常重要
- 检查所有表的create_time是否都有了
- todo 登陆时，如果用户没有角色，也就没有资源，这时候会出错的。比如新注册的用户要登陆。处理这个空指针问题。
- 主办方访问的时候，还是用到了内管的JWTFilter，辛亏内管和主办方都有一个叫110的用户，要不然就报错了，具体见4.13的日志。


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

##3.29
1. 实现了jwt 和 spring security
2. 实现这两个功能，改动了几个文件：
   - util 文件夹：新增JwtUtil
   - config 文件夹，新增 UserDetailsImpl
   - config 文件夹，新增 SecurityConfig
   - config 文件夹，新增 JwtTokenFilter
   - config 文件夹，新增 AuthenticationEntryPointImpl
   - config 文件夹，新增 AccessDeniedHandlerImpl
3. 明天开始写小程序

## 4.3凌晨
1. 修改了一个model及其mapper（报名记录）
2. 写了微信获取订单信息的DTO

## 4.3深夜
添加依赖和准备类
- pagehelper
- commonpage公共类

接下来分页两步走
1. Service 中：`PageHelper.startPage(pageNum,pageSize);`
2. Controller 中：`return CommonResult.success(CommonPage.restPage(list));`

## 4.13
- 注意，资源标识，对应前端的roles（用于生成动态路由）
- `data.put("roles",resourceService.getResourceNameForRouter(admin.getId()));`
下面是授权相关
- 今天新增了1个文件`config/UserDetailsForOrganizerImpl`,这个是给主办方的用户细节。
- 修改了1个文件`config/SecurityConfig`,加了一个@Bean方法，给主办方的，因为主办方不需要查资源。（并且我改动了主办方登录接口，手动返回一个`organizer`角色）
- 但是！！！主办方访问接口会调用jwtfilter类，这是内管的，需要分开，现在不懂，只能记下todo。

出现一个更新无效的情况
- `contestMapper.updateByPrimaryKey(contest)`，后来我换成`contestMapper.updateByPrimaryKeySelective(contest)`才可以

