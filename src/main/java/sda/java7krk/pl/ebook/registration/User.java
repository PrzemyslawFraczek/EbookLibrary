package sda.java7krk.pl.ebook.registration;

public  class User {

    private String password;
    private String name;



    public User(String name, String password ) {
        this.password = password;
        this.name = name;

    }

    public String getName() {
        return name;
    }

}
