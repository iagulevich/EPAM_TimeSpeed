import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //System.out.println(new DataManager().getTime("10 h"));
        try {
            System.out.println(new DataManager(new Reader(args[0]).read()).getSpeeds());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
