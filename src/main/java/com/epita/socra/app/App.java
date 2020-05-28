package com.epita.socra.app;

import java.util.*;
import com.epita.socra.app.tools.*;

/**
 * Convert Arabic To Roman
 */
public final class App {
    private IOAdapter adapter;

    private App() {
        this(new ConsoleAdapter());
    }

    public App(IOAdapter adapter) {
        this.adapter = adapter;
    }

    /**
     * Convert a arabic number to an roman one
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        App application = new App();
        application.run();
    }

    /**
     * Convert an arabic number to a roman one
     *
     * @param  integer The number to be converted into Roman
     * @return Roman
     */
    private String IntToRoman(int integer){
        StringBuilder Roman = new StringBuilder("");

        //Making some buffers that contains the numbers of unity, tens, ect at the corresponding index
        List<String> unity = Arrays.asList("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX");
        List<String> tens = Arrays.asList("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC");
        List<String> hundreds = Arrays.asList("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM");
        List<String> thousands = Arrays.asList("", "M", "MM", "MMM");

        //Check if the given integer is negative and returns the error string
        if (integer < 0){
            return "Negative integers not handled";
        }
        //Check if the given integer is above handled limits and returns the error sting
        if (integer > 3000){
            return "Your number is too big (>3000)";
        }
        //Adding the thousands to Roman and subtracts it to integer
        if (integer >= 1000){
            int add = integer / 1000;
            Roman.append(thousands.get(add));
            integer = integer % 1000;
        }
        //Adding the hundreds to Roman and subtracts it to integer
        if (integer >= 100){
            int add = integer / 100;
            Roman.append(hundreds.get(add));
            integer = integer % 100;
        }
        //Adding the hundreds to Roman and subtracts it to integer
        if (integer >= 10){
            int add = integer / 10;
            Roman.append(tens.get(add));
            integer = integer % 10;
        }
        //addind the unity to Roman
        if (integer >= 0){
            Roman.append(unity.get(integer));
        }

        return Roman.toString();
    }

    /**
     * running our app that switches Arabic and Roman numbers
     */
    public void run(){
        adapter.write("Hello, write here your arabic number: (Say stop to stop)");
        //The while that make our app takes multiples entered
        while (true) {
            //read the input
            String int_string = adapter.read();
            //stop the app if asked
            if (int_string.compareTo("stop") == 0){
                return;
            }
            //thransform the input string into int
            int Aladdin = Integer.parseInt(int_string);
            //transform the int into a Roman string
            String roman_frayssinet = IntToRoman(Aladdin);
            //print whats needed
            adapter.write("This is it's translation in Roman, " + roman_frayssinet);
        }
    }
}
