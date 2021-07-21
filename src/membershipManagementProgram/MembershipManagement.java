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

    public String addMembers(LinkedList<Member> m) {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> calc;

        System.out.println("Enter the member's name:");
        name = reader.nextLine();

        printClubOptions();
        System.out.println("Enter club ID that member has access to:");
        club = getIntInput();

        while (club < 1 || club > 4) {
            System.out.println("INVALID ENTRY: " + club);
            System.out.println("Enter club ID that member has access to (1-4):");
            club = getIntInput();
        }

        // Assign member id to member
        if(m.size() > 0) {
            memberID = m.getLast().getMemberID();
        } else {
            memberID = 1;
        }

        // Calculate fees for member type.
        if(club != 4) {
            // Add a single member
            calc = (n) -> {
                switch (n) {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };

            fees = calc.calculateFees(club);
            mbr = new SingleClubMember('S', memberID, name, fees, club);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("/nSTATUS: Single Club Member added\n");
        } else {
            // Add a multi member
            calc = (n) -> {
                switch (n) {
                    case 4:
                        return 1200;
                    default:
                        return -1;
                }
            };

            fees = calc.calculateFees(club);
            mbr = new MultiClubMember('M', memberID, name, fees, 100);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("/nSTATUS: Multi Club Member added\n");
        }

        return mem;
    }
}
