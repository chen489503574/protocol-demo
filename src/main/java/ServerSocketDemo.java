import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Chenjf on 2019/1/6.
 * 简单的一个基于TCP|IP  的 Socket案例通信，服务端
 */
public class ServerSocketDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        BufferedReader bufferedReader = null;
        try {
            serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();//等待客户端连接
            //拿到客户端传过来的输入流（包装后的）
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader!=null){
                bufferedReader.close();
            }
            if(serverSocket!=null){
                serverSocket.close();
            }
        }
    }
}
