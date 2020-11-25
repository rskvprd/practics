package ex1;

import ex2.AbstractChairFactory;

public class Test {
    public static void main(String[] args) {
        ConcreteFactory factory = new ConcreteFactory();
        System.out.println(factory.CreateComplex(10, 10));
    }
}
