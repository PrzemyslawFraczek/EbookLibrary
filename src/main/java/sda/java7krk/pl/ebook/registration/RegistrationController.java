package sda.java7krk.pl.ebook.registration;



public class RegistrationController {
    private UserStorage users;

    public RegistrationController(UserStorage users) {
        this.users = users;
    }

    public Response register(String name, String password) {


        Response response = new Response();

        if (isPasswordTooShort(password)) {
            response.setSuccess(false);
            response.setMassage("password is too short");

        }else if (isUserExist(name)) {
            response.setMassage("User exist, change name or password");
            response.setSuccess(false);
        }  else {
            response.setSuccess(true);
            users.add(users.creatUser(name,password));

        }
        return response;
    }

    private boolean isUserExist(String name) {
        return users.userExist(name);
    }

    private boolean isPasswordTooShort(String password) {
        return password.length() < 7;
    }

}
