import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

/**
 * Created by Chenjf on 2019/1/6.
 * 全双工小例子，服务端双向通信的小例子
 */
public class ServerDemo1 {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080);
            Socket socket = server.accept();

            //全双工，技能接收消息，也能发送消息
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());

            //通过控制台进行信息的输入
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

            //拿到客户端的信息
            System.out.println("Client:"+is.readLine());

            //读取输入的信息，判断信息是否结束
            String line = sin.readLine();
            while ("bye".equals(line)){
                //把输入的信息发送出去
                os.println(line);
                os.flush();
                System.out.println("Server:"+line);
                System.out.println("Client:"+is.readLine());
                //重新赋值
                line = sin.readLine();
            }

            //简单关闭资源，简单粗暴
            is.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
