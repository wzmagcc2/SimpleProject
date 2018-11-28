package com.wzm.pattern.order;
//命令调用者
public class Invoker {
	private Command command = null;
	
	public Invoker(Command command) {
		this.command = command;
	}
	
	public void doAction() {
		command.execute();
	}
}
