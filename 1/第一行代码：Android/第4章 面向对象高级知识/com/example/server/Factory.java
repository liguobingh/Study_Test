
package com.example.server;

class Factory {
	public static Fruit getInstance(String className) {
		if ("apple".equals(className)) {
			return new Apple();
		} else if ("orange".equals(className)) {
			return new Orange();
		} else {
			return null;
		}
	}
}