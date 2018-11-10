package support;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    /*public List<String> readAll() throws IOException {
          return   Files.readAllLines(Paths.get(s));
    }*/



}
