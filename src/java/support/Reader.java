package support;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private String s;

    public Reader(String s) {
        this.s = s;
    }

    public List<String> read() throws IOException{

        ArrayList<String> list = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(s))){

            String inp ;

            while ((inp = reader.readLine()) != null){
                list.add(inp);
            }

        }
        return list;
    }


}
