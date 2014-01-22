package sis.summer;

import junit.framework.TestCase;

public class SuperClassTest extends TestCase {

    public void testConstructorClass() {
//        SuperClass superClass = new SubClass();
        SuperClass superClass = new SuperClass("parm");
        SubClass subClass = new SubClass("parm");
        assertTrue(SuperClass.constructorWasCalled);
    }
}

class SuperClass {
    static boolean constructorWasCalled = false;

    public SuperClass(String parm) {
        constructorWasCalled  = true;
        System.out.println("Super Class");
    }
}

class SubClass extends SuperClass {
    public SubClass(String parm) {
        super(parm);
        System.out.println("Sub Class");
    }
}