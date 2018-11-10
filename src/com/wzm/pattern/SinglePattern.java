package com.wzm.pattern;

public class SinglePattern {
	
	private SinglePattern() {}
	
	private static class Single {
		final static SinglePattern INSTANCE = new SinglePattern();
	}
	
	public static SinglePattern getInstance() {
		return Single.INSTANCE;
	}
}
