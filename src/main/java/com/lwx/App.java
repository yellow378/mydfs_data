package com.lwx;

import com.lwx.util.Client;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Client client = new Client("192.168.228.10", 8085);
        client.start();
        System.out.println("check");
    }
}
