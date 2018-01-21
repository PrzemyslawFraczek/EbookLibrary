package sda.java7krk.pl.ebook.registration;

import java.util.Map;

public class RegistrationController {
    private UserStorage users;

    public RegistrationController(UserStorage users) {
        this.users = users;
    }

    public Response register(String name, String password) {


        Response response = new Response();

        if (password.length() < 7) {
            response.setSuccess(false);
            response.setMassage("password is too short");

        }else if (users.userExist(name)) {
                    response.setMassage("User exist, change name or password");
                    response.setSuccess(false);
        }  else {
            response.setSuccess(true);
        }
        return response;
    }

}
