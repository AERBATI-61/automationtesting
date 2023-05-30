package Testng;

import org.testng.annotations.Test;

public class RunMethods {
    @Test(priority = 2)
    void callMethod1(){
        System.out.println("I'm a method 1");
    }

    @Test
    void callMethod2(){
        System.out.println("I'm a method 2");
    }
}
