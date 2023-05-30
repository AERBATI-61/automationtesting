package Testng;

import org.testng.annotations.Test;

public class Group1 {
    @Test (groups = {"smoke", "regression"})
    void answer1(){
        System.out.println("it's not true");
    }

    @Test (groups = {"regression"})
    void answer2(){
        System.out.println("it's true");
    }


    @Test (groups = {"smoke"})
    void answer3(){
        System.out.println("yes it's false");
    }
}
