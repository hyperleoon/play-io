package com.hyperleon.play.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * @author leon
 * @date 2021-04-30 15:31
 **/
public class BioServer<T> implements Server<T> {

    private String servername;

    private ExecutorService executorService;

    private ServerSocket serverSocket;

    public BioServer(ServerSocket serverSocket,ExecutorService executorService) {
        this.executorService = executorService;
        this.serverSocket = serverSocket;
    }

    public BioServer(ServerSocket serverSocket,String servername,ExecutorService executorService) {
        this.servername = servername;
        this.executorService = executorService;
        this.serverSocket = serverSocket;
    }

    @Override
    public Socket getSocket(Integer port) throws IOException {
        return serverSocket.accept();
    }

    @Override
    public <E extends ExecutorService> void configProcessExecutor(E executor) {
        this.executorService = executor;
    }

    @Override
    public T process(SocketTask task) {
         executorService.submit(task);
         return null;
    }

    @Override
    public String getName() {
        return this.servername;
    }

    @Override
    public void configName(String name) {
        this.servername = name;
    }


}
