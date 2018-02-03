package sda.java7krk.pl.ebook.domena;

import java.io.*;

public class UserStorage {

    private File file = new File("user.txt");

    public void save(String name, String password) throws IOException {

        PrintWriter addingToFile = new PrintWriter(new FileOutputStream(file, true));
        BufferedWriter bw = new BufferedWriter(addingToFile);

        String record = name + " ; " + password;
        try {
            bw.write(record + '\n');
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean userExist(String name){
        
    }

}
