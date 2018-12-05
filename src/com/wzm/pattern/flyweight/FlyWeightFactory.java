package com.wzm.pattern.flyweight;

import java.util.Hashtable;

//享元工厂
public class FlyWeightFactory {

	//存放享元对象的公共场所
	private static final Hashtable<String,FlyWeight> flyWeights = new Hashtable();
	
	//如下有点偏向单例行为
	public static FlyWeight getFlyWeight(String name) {
		FlyWeight flyWeight = flyWeights.get(name);
		if(flyWeight == null) {
			if(name.equals("ConcreteFlyWeight"))
				flyWeights.put(name, new ConcreteFlyWeight());
		}
		return flyWeight;
	}
}
