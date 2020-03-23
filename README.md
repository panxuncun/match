## 3.24
搞了一个自动机，一开始 spring 官网那个我没看懂，它里面有一个 Builder 我不太清楚是一个类还是一个方法，推测是类似构造器之类的东西。现在没有能力搞懂，所以抄了一个能用的。地址看这里https://blog.csdn.net/gwd1154978352/article/details/79577597。

分为这几步：
- 新建两个枚举类。一个是事件 Events，一个是状态 States
- 配置类 StateMachineConfig, 里面写source -> event ->target, 不过他的格式是 **源.目的.事件** source(States.STATE1).target(States.STATE2).event(Events.EVENT1)。但是里面重写了一个方法，里面好多if，官方的做法也是这么多吗？
- controller 里面调用。首先是@Autowired private StateMachine<States, Events> stateMachine;然后stateMachine.start();stateMachine.sendEvent(Events.PAY);stateMachine.sendEvent(Events.RECEIVE);就好了。
今天先到这里。