package Maven;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Profile {
    @Test
    public void plugin(){
        Assert.assertEquals("Arafat", "Arafat");
    }
}
