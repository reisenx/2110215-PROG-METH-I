package application.util;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.Function;

public class ChoiceUtil {

    protected PrintStream out;
    protected Scanner in;

    public ChoiceUtil(PrintStream out, Scanner in) {
        this.out = out;
        this.in = in;
    }

    public int getChoice(int minChoice, int maxChoice, Runnable prompt) {
        return getChoice(minChoice, maxChoice, prompt, n -> n.toString());
    }

    public int getChoice(int minChoice, int maxChoice, boolean ensureSelection, Runnable prompt) {
        return getChoice(minChoice, maxChoice, ensureSelection, prompt, n -> n.toString());
    }

    public int getChoice(int minChoice, int maxChoice, Runnable prompt, Function<Integer, String> choiceNameFn) {
        return getChoice(minChoice, maxChoice, true, prompt, choiceNameFn);
    }

    public int getChoice(int minChoice, int maxChoice, boolean ensureSelection, Runnable prompt, Function<Integer, String> choiceNameFn) {
        while(true) {
            prompt.run();
            int choice = in.nextInt();
            if (minChoice <= choice && choice <= maxChoice) {
                if(!ensureSelection) {
                    return choice;
                }

                if(this.ensureSelection(choice, choiceNameFn)) {
                    return choice;
                }
            } else {
                out.println("Please input number from " + minChoice + " to " + maxChoice + ".");
            }
        }
    }

    public boolean ensureSelection(int choice) {
        return ensureSelection(choice, n -> n.toString());
    }

    public boolean ensureSelection(int choice, Function<Integer, String> choiceNameFn) {
        out.println("Select " + choiceNameFn.apply(choice) + " ?(y/n)");
        in.nextLine();
        while(true) {
            char confirm = in.nextLine().toLowerCase().charAt(0);
            if(confirm == 'y') {
                return true;
            } else if (confirm == 'n') {
                return false;
            } else {
                out.println("Please input y or n");
            }
        }
    }

}
