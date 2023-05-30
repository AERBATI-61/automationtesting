package Testng;

import org.testng.annotations.Test;

public class Include_Exclude {
    @Test
    void includeMethod(){
        System.out.println("I'm include method!");
    }


    @Test
    void excludeMethod(){
        System.out.println("I'm exclude method!");
    }
}
