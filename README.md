# shuma-yonghe-project

项目采用SpringCloud 微框架搭建

基本组件满足微服务的要求,基本组件有
  1.服务注册中心()
  2.微服务()
  3.负载均衡和熔断器()
  4.配置中心()
  5.网关和过滤器()
  6.Hystrix 监控数据聚合()
  7.Hystrix 监控面板()
  8.分布式服务跟踪()
  
  zipkin 启动命令
  java -jar zipkin-server-2.11.12-exec.jar --zipkin.collector.rabbitmq.addresses=10.20.0.66 --zipkin.collector.rabbitmq.username=shuma  --zipkin.collector.rabbitmq.password=q1w2e3r4
