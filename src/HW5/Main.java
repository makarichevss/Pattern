package HW5;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Compress arch = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File file = new File("C:\\");
        System.out.println("Choose compress type:\n1:zip\n2:rar\n");
        String s = reader.readLine();

        if (s.contains("1"))
            arch = new Zip();
        else if (s.contains("2"))
            arch = new Rar();
        else
            System.out.println("Unknown type");

        if (arch != null)
            arch.compress(file);
    }
}