package sda.java7krk.pl.ebook.registration;

public class RegistrationController {
    public Response register(String name, String password) {
        Response response = new Response();

        if (password.length() < 7) {
            response.setMassage("Hasło za krótkie");
            response.setSuccess(false);
        } else {
            response.setSuccess(true);


        }
        return response;
    }


}
