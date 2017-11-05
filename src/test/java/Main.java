import java.io.IOException;
import java.net.Socket;

/**
 * Created by caiyl on 2017/3/15.
 */
public class Main {
    public static void main(String[] args) {
        Runtime a = Runtime.getRuntime();

        try {
            a.exec("perfmon");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
