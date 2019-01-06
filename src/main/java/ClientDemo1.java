import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Chenjf on 2019/1/6.
 * 全双工小例子，客户端双向通信的小例子
 */
public class ClientDemo1 {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1",8080);
            //通过控制台进行信息的输入
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            //全双工，技能接收消息，也能发送消息
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = sin.readLine();

            while (!"bye".equals(line)){
                os.println(line);
                os.flush();
                System.out.println("Client:"+line);
                System.out.println("Server:"+is.readLine());
                line = sin.readLine();
            }

            //简单粗暴关闭资源
            os.close();
            is.close();
            socket.close();




        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
