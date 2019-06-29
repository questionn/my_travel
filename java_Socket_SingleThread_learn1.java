//简单的单线程通信（Socket）
//客户端
package com.tom.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadClient {
    public static void main(String[] args) throws IOException {
        //与服务器建立连接
        Socket client = new Socket("127.0.0.1",20101);
        System.out.println("连接成功!!!");

        //拿到输出流向服务器发送消息
        PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
        out.println("Hello , this is client");

        //接受消息
        Scanner in = new Scanner(client.getInputStream());
        if(in.hasNextLine()){
            String str = in.nextLine();
            System.out.println("服务器端发来消息"+str);
        }

        out.close();
        in.close();
        client.close();
    }
}
//服务器端
package com.tom.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadServer {
    public static void main(String[] args) throws IOException {
        //创建服务器端
        ServerSocket serverSocket = new ServerSocket(20101);
        //等待客户端连接
        System.out.println("等待连接。。。。");
        Socket socket = serverSocket.accept();
        System.out.println("连接成功!!!");

        //接受消息
        Scanner in = new Scanner(socket.getInputStream());
        if(in.hasNextLine()){
            String s = in.nextLine();
            System.out.println("客户端消息"+s);
        }

        //发送消息
        PrintStream out = new PrintStream(socket.getOutputStream(),true,"UTF-8");
        out.println("Hello,This is server");

        in.close();
        out.close();
        socket.close();
    }
}
