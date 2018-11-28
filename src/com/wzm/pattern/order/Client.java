package com.wzm.pattern.order;

//客户端，其实就是测试类
public class Client {

	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		Invoker invoker = new Invoker(command);
		invoker.doAction();
	}
}
