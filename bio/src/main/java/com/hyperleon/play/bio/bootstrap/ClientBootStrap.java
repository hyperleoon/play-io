package com.hyperleon.play.bio.bootstrap;

import com.hyperleon.play.bio.Client;
import com.hyperleon.play.bio.Constant;
import com.hyperleon.play.bio.LogClient;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author leon
 * @date 2021-04-30 16:40
 **/
public class ClientBootStrap {

    public static void main(String[] args) throws IOException {
        Client client = new LogClient<>();
        client.configName("from-" + Thread.currentThread().getId());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            client.send(new Socket(Constant.PROXY,Constant.PORT), client.getName() + ":" + scanner.nextLine());
        }
    }
}
