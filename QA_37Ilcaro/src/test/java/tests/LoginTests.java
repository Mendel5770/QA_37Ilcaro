package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("noa@gmail.com","Nnoa12345$");
        app.getHelperUser().submitLogin();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        app.getHelperUser().closeWindow();


    }

    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("noagmail.com", "Nnoa12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }


    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("pop@gmail.com", "Pop12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }
}



