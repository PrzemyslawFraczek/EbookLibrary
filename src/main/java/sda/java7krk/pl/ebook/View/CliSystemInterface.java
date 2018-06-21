package sda.java7krk.pl.ebook.View;

import java.util.Scanner;

public class CliSystemInterface implements SystemInterface {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void display(String s) {
        System.out.println(s);
    }

    @Override
    public String readInformation() {
        return scanner.next();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }
}
