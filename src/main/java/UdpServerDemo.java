import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by Chenjf on 2019/1/6.
 * 简单粗暴的一个基于 UDP|IP  的 Socket案例通信（资源都没释放），服务端
 * 这里有个bug，服务端启动不能长时间监听，待解决
 *
 */
public class UdpServerDemo {
    public static void main(String[] args) throws IOException {
        //创建服务，并且接收一个数据包
        DatagramSocket datagramSocket = new DatagramSocket(8080);//定义服务端接口
        byte[] receiveData = new byte[1024];//构建接收包的基础
        DatagramPacket receivePackage =
                new DatagramPacket(receiveData,receiveData.length);//根据byte数组构建接收包

        datagramSocket.receive(receivePackage);

        System.out.println(new String(receiveData,0,receiveData.length));
    }
}
