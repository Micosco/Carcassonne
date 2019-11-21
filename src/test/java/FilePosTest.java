import java.io.FileWriter;
import java.io.IOException;

public class FilePosTest {
    public static void main(String[] args) throws IOException {
        FileWriter a = new FileWriter("a.txt");
        a.close();
    }
}
