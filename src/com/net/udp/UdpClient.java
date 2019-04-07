package com.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 基本流程: 发送端
 * 1、使用DatagramSocket  指定端口 创建发送端
 * 2、准备数据 一定转成字节数组
 * 3、 封装成DatagramPacket 包裹，需要指定目的地
 * 4、发送包裹send​(DatagramPacket p) * 
 * 5、释放资源
 * @author Administrator
 *
 */
public class UdpClient {

	public static void main(String[] args) throws Exception {
		
		System.out.println("发送方启动中.....");
		//1、使用DatagramSocket  指定端口 创建发送端
		DatagramSocket datagramSocket = new DatagramSocket(8888);
		//2、准备数据 一定转成字节数组
		String msg = "哈哈哈，我发送了";
		byte[] sendMsg = msg.getBytes();
		//3、 封装成DatagramPacket 包裹，需要指定目的地
		DatagramPacket datagramPacket = new DatagramPacket(sendMsg, sendMsg.length, 
				new InetSocketAddress("localhost", 6666));
		//4、发送包裹send​(DatagramPacket p) * 
		datagramSocket.send(datagramPacket);
		//5、释放资源
		datagramSocket.close();
	}
}
