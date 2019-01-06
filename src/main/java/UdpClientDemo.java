import java.io.IOException;
import java.net.*;

/**
 * Created by Chenjf on 2019/1/6.
 * 简单粗暴的一个基于 UDP|IP  的 Socket案例通信（资源都没释放），客户端
 */
public class UdpClientDemo {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        //构建发送数据包
        byte[] sendData = "Hello,佳阳".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(sendData,sendData.length,address,8080);
        //用UDP 协议的Socket发送数据包数据
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(datagramPacket);


    }
}
