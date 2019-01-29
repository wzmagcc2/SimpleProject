package com.wzm.pattern;

import org.junit.Assert;

import com.wzm.pattern.flyweight.FlyWeight;
import com.wzm.pattern.flyweight.FlyWeightFactory;
import org.junit.Test;

public class PatternTest {

	//测试单例模式
	@Test
	public void testSinglePattern() {
		SinglePattern single1 = SinglePattern.getInstance();
		SinglePattern single2 = SinglePattern.getInstance();
		Assert.assertEquals(single1, single2);
		System.out.println(single1 == single2);
	}
	
	//测试享元模式
	@Test
	public void testFlyWeight() {
		FlyWeight flyWeight1 = FlyWeightFactory.getFlyWeight("ConcreteFlyWeight");
		FlyWeight flyWeight2 = FlyWeightFactory.getFlyWeight("ConcreteFlyWeight");
		FlyWeight flyWeight3 = FlyWeightFactory.getFlyWeight("ConcreteFlyWeight");
		//flyWeight1.operation();
		flyWeight2.operation();
		flyWeight3.operation();
		if(flyWeight2 == flyWeight3) {
			System.out.println("采用了享元模式");
		}
	}
}
