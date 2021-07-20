package membershipManagementProgram;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    final private Scanner reader = new Scanner(System.in);

    private int getIntInput() {
        int choice = 0;

        while(choice == 0) {
            try {
                choice = reader.nextInt();

                if(choice == 0)
                    throw new InputMismatchException();

                reader.nextLine();
            } catch (InputMismatchException e) {
                reader.nextLine();
                System.out.println("ERROR: INVALID INPUT. Please try again: ");
            }
        }

        return choice;
    }

    private void printClubOptions() {
        System.out.println("Club Mercury");
        System.out.println("Club Neptune");
        System.out.println("Club Jupiter");
        System.out.println("Multi Clubs");
    }

    public int getChoice() {
        int choice;

        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("===============================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("Display Member Information");
        System.out.print("Please select an option (or Enter -1 to quit");

        choice = getIntInput();

        return choice;
    }
}
