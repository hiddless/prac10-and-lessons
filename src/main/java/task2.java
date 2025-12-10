import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scn = null;
        try {
            File file = new File("data.txt");
            scn = new Scanner(file);
            while (scn.hasNextLine()) {
                System.out.println(scn.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("an error occurred.");
        } finally {
            if (scn != null) {
                scn.close();
            }
        }
    }
}