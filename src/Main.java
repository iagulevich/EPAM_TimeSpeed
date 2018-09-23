import support.DataManager;
import support.Reader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //System.out.println(new support.DataManager().getTime("10 h"));
        try {
            System.out.println(new DataManager(new Reader(args[0]).read()).getSpeeds());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
