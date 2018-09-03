# springcloud-microservicecloud-test
以springcloud作为微服务架构，测试Eureka、Ribbon、Hystrix、zuul、SpringCloud Config等功能

开发工具：eclipse  
开发环境：jdk1.8+oracle11<br />
         springboot：1.5.9.RELEASE<br />
         springcloud：Dalston.SR1<br />
         
项目结构：整套开发技术栈以SpringCloud为主，单个微服务模块以SpringMVC+SpringBoot/Spring+Mybatis组合进行开发。<br />
      公共子模块：microservicecloud-api<br />
      微服务提供者：microservicecloud-provider-dept-8001、microservicecloud-provider-dept-8002、microservicecloud-provider-dept-8003<br />
      微服务消费者：microservicecloud-consumer-dept-80<br />
      服务注册中心Eureka集群：microservicecloud-eureka-7001、microservicecloud-eureka-7002、microservicecloud-eureka-7003<br />
      客户端Feign模块：microservicecloud-consumer-dept-feign<br />
      熔断机制的微服务：microservicecloud-provider-dept-hystrix-8001<br />
      微服务监控消费端hystrixDashboard模块：microservicecloud-consumer-hystrix-dashboard<br />
      路由zuul模块：microservicecloud-zuul-gateway-9527<br />
      分布式配置中心SpringCloudConfig模块<br />
