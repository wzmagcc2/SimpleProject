package com.wzm.pattern;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PatternTest {

	@Test
	public void testSinglePattern() {
		SinglePattern single1 = SinglePattern.getInstance();
		SinglePattern single2 = SinglePattern.getInstance();
		Assert.assertEquals(single1, single2);
		System.out.println(single1 == single2);
	}
}
