package com.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean{ //boot -->相当于spring中的applicationContext.xml --- @Configuration配置   ConfigBean = applicationContext.xml
	@Bean
	@LoadBalanced	//开启负载均衡
	public RestTemplate gRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public IRule myRule() {
		return new RandomRule();//用我们重新选择的随机算法，替代默认的轮询
	}
}
//@Bean
//public UserServcie getUserServcie()
//{
//	return new UserServcieImpl();
//}
//applicationContext.xml == ConfigBean(@Configuration)
//<bean id="userServcie" class="com.atguigu.tmall.UserServiceImpl">