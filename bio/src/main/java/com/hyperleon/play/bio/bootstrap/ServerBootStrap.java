package com.hyperleon.play.bio.bootstrap;

import com.hyperleon.play.bio.BioServer;
import com.hyperleon.play.bio.Constant;
import com.hyperleon.play.bio.LogSocketTask;
import com.hyperleon.play.bio.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * @author leon
 * @date 2021-04-30 15:13
 **/
public class ServerBootStrap {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(Constant.PORT);
        Server<String> server = new BioServer<>(serverSocket, Executors.newFixedThreadPool(10));
        while (true) {
            server.process(new LogSocketTask(server.getSocket(Constant.PORT)));
        }
    }
}
