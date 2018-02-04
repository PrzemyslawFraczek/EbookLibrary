package sda.java7krk.pl.ebook.domena;

import java.io.*;
import java.util.Scanner;

public class UserStorage {

    private File file;

    public UserStorage(File file) {
        this.file = file;
    }

    public void save(String name, String password) throws IOException {
        FileOutputStream fos = new FileOutputStream(file, true);
        PrintWriter addingToFile = new PrintWriter(fos, true);
        BufferedWriter bw = new BufferedWriter(addingToFile);

        String record = name + ";" + password;
        try {
            bw.write(record);
            bw.newLine();

            bw.close();
            addingToFile.close();
            fos.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public boolean userExist(String name) throws FileNotFoundException {
        if(file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String newLine = scanner.nextLine();
                String[] str = newLine.split(";");
                if (str[0].equals(name)) {
                    scanner.close();
                    return true;
                }
            }
            scanner.close();
            return false;
        } else {
            return false;
        }
    }
    public boolean userExist(String name , String passwod) throws FileNotFoundException {
        if(file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String newLine = scanner.nextLine();
                String[] str = newLine.split(";");
                if (str[0].equals(name) && str[1].equals(passwod)) {
                    scanner.close();
                    return true;
                }
            }
            scanner.close();
            return false;
        } else {
            return false;
        }
    }

}
