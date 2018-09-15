import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println(args[0]);
        try {
            System.out.println(new Reader(args[0]).read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
