package com.wzm.pattern.order;

public class Invoker {
	private Command command = null;
	
	public Invoker(Command command) {
		this.command = command;
	}
	
	public void doAction() {
		command.execute();
	}
}
