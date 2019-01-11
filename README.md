# shuma-yonghe-project

项目采用SpringCloud 微框架搭建

环境：
   1. JDK8
   2. maven 3.5.9
   3. SpringBoot 2.0.4.RELEASE
   4. SpringCloud Finchley.RC1

组件列表  
   Redis、Rabbit、MQ、Mysql    

基本组件满足微服务的要求,基本组件有
  1. 服务注册中心([Eureka-Server](https://github.com/IceNardus/shuma-yonghe-project/tree/master/yonghe))
  2. 微服务([Eureka-Client](https://github.com/IceNardus/shuma-yonghe-project/tree/master/yonghe-min-parent/min-api))
  3. 负载均衡和熔断器()
  4. 配置中心()
  5. 网关和过滤器()
  6. Hystrix 监控数据聚合()
  7. Hystrix 监控面板()
  8. 分布式服务跟踪(Ziplin)
  
 zipkin 启动命令
 java -jar zipkin-server-2.11.12-exec.jar --zipkin.collector.rabbitmq.addresses=10.20.0.66 --zipkin.collector.rabbitmq.username=shuma  --zipkin.collector.rabbitmq.password=q1w2e3r4
