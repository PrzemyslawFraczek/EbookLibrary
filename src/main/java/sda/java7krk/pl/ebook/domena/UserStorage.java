package sda.java7krk.pl.ebook.domena;

import java.io.*;
import java.util.Scanner;

public class UserStorage {

    private UserStorage users;
    private File file = new File("user.txt");

    public UserStorage(UserStorage users) {
        this.users = users;
    }

    public UserStorage() {

    }

    public void save(String name, String password) throws IOException {

        PrintWriter addingToFile = new PrintWriter(new FileOutputStream(file, true));
        BufferedWriter bw = new BufferedWriter(addingToFile);

        String record = name + ";" + password;
        try {
            bw.write(record );
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean userExist(String name) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("user.txt"));
        while (scanner.hasNext()){
            String newLine = scanner.nextLine();
            String[] str = newLine.split(";");
            if (str[0].equals(name)) {
                return true;
            }
        }
        return false;

    }
    public boolean userExist(String name , String passwod) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("user.txt"));
        while (scanner.hasNext()){
            String newLine = scanner.nextLine();
            String[] str = newLine.split(";");
            if (str[0].equals(name) && str[1].equals(passwod)) {
                return true;
            }
        }
        return false;
    }

}
