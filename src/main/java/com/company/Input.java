package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Input {

    public static String inputString(String question, String regex) throws IOException {
//        try{
            System.in.reset();
//        } catch (IOException exception) {
//            exception.getStackTrace();
//        }
        Scanner scanner = new Scanner(System.in);
        String in;
        String str;
        char m = '\0';
        do {
            do {
                System.out.println(question);
                str = scanner.nextLine().trim();
            } while (!str.matches(regex));
            do {
                System.out.print("You've entered: \"" + str);
                System.out.print("\".\nAccept? ( Y / N )\n");
                in = scanner.nextLine().trim();
                if (in.length() > 0) {
                    m = in.toLowerCase()
                            .charAt(0);
                }
            } while(m != 'y' && m != 'n');
        } while(m != 'y');
        return str;
    }

    //origin and end inclusive
    public static int inputInt(String question, int origin, int end) throws IOException {
        int number;
        do {
            number = Integer.parseInt(inputString(question, "\\d+"));
        } while (number < origin || number > end);

        return number;
    }
}
