import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EnvVar {

    private Scanner reader;
    private String filename;

    public EnvVar(String filename) {
        this.filename = filename;
        resetReader();
    }

    private void resetReader() {
        try {
            File envFile = new File(filename);
            this.reader = new Scanner(envFile);
        } catch(FileNotFoundException e) {

        }
    }

    public String get(String var) {

        while(this.reader.hasNextLine()) {
            String[] data = this.reader.nextLine().split("=");
            if(var.equals(data[0])) {
                resetReader();
                return data[1];
            }
        }

        resetReader();
        return null;
    }

}
