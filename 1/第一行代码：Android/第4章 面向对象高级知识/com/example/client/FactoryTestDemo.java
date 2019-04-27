
package com.example.client;

import com.example.server.*;

public class FactoryTestDemo {
	public static void main(String args[]) {
		Fruit fruit = Factory.getInstance("apple");
		fruit.eat();
	}
}