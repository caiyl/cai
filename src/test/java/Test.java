package cai;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

/**
 *
 * @author howsky
 *
 */
public class Test  {
    // Sock begin----------------------------------------------
    private Socket sid;
    private PrintWriter out;
    private BufferedReader in;
    private String ip;
    private String port;
    // Sock end------------------------------------------------

    private static String label = "howsky.net";

    public static void main(String[] args) throws IOException {
        byte[] req = ("QUERY TIME ORDER" + System.getProperty("line.separator"))
                .getBytes();

        Socket socket = new Socket("localhost", 8080);

//        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        for (int i = 0; i < 100; i++) {

            out.println(req);
        }
    }


    /**
     * 发送消息
     *
     * @param ip
     * @param port
     * @param msg
     * @throws Exception
     */
    private void sendMsg(String ip, int port, String msg) throws Exception {
        sid = new Socket(ip, port);
        in = new BufferedReader(new InputStreamReader(sid.getInputStream()));
        out = new PrintWriter(sid.getOutputStream(), true);
        out.println(msg);
        in.readLine();
        System.out.println("success");
    }
}