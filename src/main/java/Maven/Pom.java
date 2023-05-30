package Maven;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Pom {
    WebDriver driver;

    @Test
    public void testNg(){
        Assert.assertEquals("arafat", "arafat");
    }
}
