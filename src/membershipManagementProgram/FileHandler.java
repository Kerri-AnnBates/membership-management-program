package membershipManagementProgram;

import java.util.LinkedList;
import java.io.*;

public class FileHandler {

    public LinkedList<Member> readFile() {
        LinkedList<Member> m = new LinkedList<>();
        String lineRead;
        String[] splitLine;
        Member mem;

        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            lineRead = reader.readLine();

            // Read each line and put in array variable.
            while (lineRead != null) {
                splitLine = lineRead.split(", ");

                // Create members based on type.
                if (splitLine[0].equals("S")) {
                    mem = new SingleClubMember('S',
                            Integer.parseInt(splitLine[1]),
                            splitLine[3],
                            Double.parseDouble(splitLine[3]),
                            Integer.parseInt(splitLine[4])
                    );
                } else {
                    mem = new MultiClubMember('M',
                            Integer.parseInt(splitLine[1]),
                            splitLine[3],
                            Double.parseDouble(splitLine[3]),
                            Integer.parseInt(splitLine[4])
                    );
                }

                m.add(mem);
                lineRead = reader.readLine();
            }

        } catch(IOException e) {

        }

        return m;
    }
}
