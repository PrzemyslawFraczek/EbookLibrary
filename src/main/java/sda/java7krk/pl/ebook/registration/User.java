package sda.java7krk.pl.ebook.registration;

public  class User {

    private String password;
    private String name;


    public User(String name, String password) {
        this.password = password;
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User add(String name , String password){
        return null;
    }
}
