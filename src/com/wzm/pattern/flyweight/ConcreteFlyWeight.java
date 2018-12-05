package com.wzm.pattern.flyweight;

//具体的享元对象
public class ConcreteFlyWeight implements FlyWeight {

	@Override
	public void operation() {
		System.out.println("ConcreteFlyWeight:"+this.toString());
	}

}
