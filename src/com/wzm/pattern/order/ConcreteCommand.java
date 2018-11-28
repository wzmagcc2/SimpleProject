package com.wzm.pattern.order;

//具体命令子类
public class ConcreteCommand implements Command {

	private Receiver receiver;//持有能够执行该命令的命令接受者
	
	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.action();
	}

}
