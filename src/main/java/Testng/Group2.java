package Testng;

import org.testng.annotations.Test;

public class Group2 {
    @Test (groups = {"smoke", "regression"})
    void question1(){
        System.out.println("is it true?");
    }

    @Test (groups = {"smoke","regression"})
    void question2(){
        System.out.println("is it false?");
    }
}
