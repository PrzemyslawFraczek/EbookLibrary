package sda.java7krk.pl.ebook.registration;

import java.util.ArrayList;
import java.util.List;

public class RegistrationController {


    public Response register(String name, String password) {

        List<Users> users = new ArrayList<Users>();
        Response response = new Response();

        users.add(new Users("aaa", "12345678"));
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                response.setMassage("User exist, change name or password");
                response.setSuccess(false);

            } else {
                response.setSuccess(true);
                if (password.length() < 7){
                    response.setSuccess(false);
                    response.setMassage("password is too short");
                }
            }
        }


//        if (password.length() > 7) {
//            response.setSuccess(true);
//        } else {
//            response.setMassage("password is too short");
//            response.setSuccess(false);
//
////        }
        return response;
    }


}
