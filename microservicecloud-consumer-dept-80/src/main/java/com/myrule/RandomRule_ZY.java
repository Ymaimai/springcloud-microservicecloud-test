package com.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class RandomRule_ZY extends AbstractLoadBalancerRule{
	// total = 0 // 当total==5以后，我们指针才能往下走
	// index = 0 // 当前对外提供服务的服务器地址
	// total需要重新置为零，但是已经达到过一个5次，我们的index = 1
	// 分析：我们5次，但是微服务只有8001 8002 8003 三台	
	private int total = 0; 			// 总共被调用的次数，目前要求每台被调用5次
	private int currentIndex = 0;	// 当前提供服务的机器号
	
	public Server choose(ILoadBalancer lb, Object key){//返回的具体服务线（8001还是8002还是8003）
		if (lb == null) {
			return null;
		}
		Server server = null;

		while (server == null) {//多线程情况下，使用while，当线程苏醒后会重新判断一次
			if (Thread.interrupted()) {//线程是否被中断，被中断时，返回null
				return null;
			}
			List<Server> upList = lb.getReachableServers();//活的，可以对外提供服务的
			List<Server> allList = lb.getAllServers();

			int serverCount = allList.size();
			if (serverCount == 0) {
				return null;
			}

            if(total < 5){
	            server = upList.get(currentIndex);//获取服务
	            total ++;
            } else {
	            total = 0;
	            currentIndex ++;
	            if(currentIndex >= upList.size()){//upList.size() ---3
	            	currentIndex = 0;
	            }
            }			
			
			
			if (server == null) {
				Thread.yield();
				continue;
			}

			if (server.isAlive()) {
				return (server);
			}

			server = null;
			Thread.yield();
		}

		return server;

	}

	@Override
	public Server choose(Object key){
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig){
		// TODO Auto-generated method stub

	}

}