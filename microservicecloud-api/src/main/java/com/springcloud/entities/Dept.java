package com.springcloud.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//implements Serializable微服务必须实现序列化接口
//@AllArgsConstructor:全参构造器注解
//@NoArgsConstructor:无参构造器注解
//@Data:set/get方法
//@Accessors(chain=true):链式访问
//@SuppressWarnings("serial")压制警告
@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable{//Dept(Entity) 实体类 类表关系映射
	private Long 	deptno; // 主键
	private String 	dname; // 部门名称
	private String 	db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库	
	//也可以自定义有参构造器
	public Dept(String dname) {
		super();
		this.dname = dname;
	}
}
