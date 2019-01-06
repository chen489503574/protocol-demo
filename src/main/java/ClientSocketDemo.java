import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Chenjf on 2019/1/6.
 * 简单的一个基于TCP|IP  的 Socket案例通信，客户端
 */
public class ClientSocketDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",8080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
//            out.print("Hello");//这个是写入不进去的
            out.println("Hello,佳阳");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (socket!=null){
                socket.close();
            }
        }
    }
}
