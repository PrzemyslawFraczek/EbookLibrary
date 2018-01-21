package sda.java7krk.pl.ebook.registration;

import java.util.List;

public class RegistrationController {


    private List<User> users;

    private RegistrationController(List<User> users) {

        this.users = users;
    }

    public Response register(String name, String password) {


        Response response = new Response();

        if (password.length() < 7) {
            response.setSuccess(false);
            response.setMassage("password is too short");

        }else {
            if (users.size() >= 1) {
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getName().equals(name)) {
                        response.setMassage("User exist, change name or password");
                        response.setSuccess(false);

                    } else {
                        response.setSuccess(true);
                    }
                }

            }
            else {
                response.setSuccess(true);
            }
        }
        return response;
    }


}
