package com.lwx.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CommunicateNameNode {
    private Socket socket;

    public CommunicateNameNode(Socket socket) {
        this.socket = socket;
    }

    public void f() {
        try {
            // 构建IO
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            // 向服务器端发送一条消息
            bw.write("测试客户端和服务器通信，服务器接收到消息返回到客户端\n");
            bw.flush();
            Scanner cin = new Scanner(System.in);

            while (true) {
                // 读取服务器返回的消息

                String mess = br.readLine();
                System.out.println("服务器：" + mess);
                mess = cin.nextLine();
                bw.write(mess + '\n');
                bw.flush();
                if (mess.equals("quit"))
                    break;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
