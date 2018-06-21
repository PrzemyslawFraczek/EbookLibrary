package sda.java7krk.pl.ebook.viewTest;

import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import sda.java7krk.pl.ebook.Login.LoginController;
import sda.java7krk.pl.ebook.View.CliSystemInterface;
import sda.java7krk.pl.ebook.View.Response;
import sda.java7krk.pl.ebook.View.StartPanel;
import sda.java7krk.pl.ebook.View.SystemInterface;
import sda.java7krk.pl.ebook.domena.UserStorage;
import sda.java7krk.pl.ebook.register.RegistrationController;
import sda.java7krk.pl.ebook.register.RegistrationPanel;

public class StartPanelTest {



    public static final String SOME_LOGIN = "SOME_LOGIN";
    public static final String SOME_PASSWORD = "SOME_PASSWORD";

    private RegistrationController registrationController = Mockito.mock(RegistrationController.class);
    private SystemInterface systemInterface = Mockito.mock(SystemInterface.class);
    private RegistrationPanel registrationPanel = Mockito.mock(RegistrationPanel.class);

    @Test
    public void shouldRegisterNewUser() {

        Response response = new Response();
        response.setSuccess(true);

        BDDMockito.given(systemInterface.readInformation()).willReturn(SOME_LOGIN, SOME_PASSWORD);
        BDDMockito.given(registrationController.register(SOME_LOGIN, SOME_PASSWORD)).willReturn(response);

        registrationPanel.registrationExample();


        Mockito.verify(systemInterface).display("God damn, you made it!");
    }

}
