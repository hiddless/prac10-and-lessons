import java.io.File;

public class task1 {
    public static void main(String[] args) {
        File file = new File("data.txt");
        if (file.exists()){
            System.out.println("file exist");
        }else {
            System.out.println("not found");
        }
    }
}
