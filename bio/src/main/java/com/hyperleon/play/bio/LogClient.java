package com.hyperleon.play.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author leon
 * @date 2021-04-30 16:25
 **/
public class LogClient<T> implements Client<T> {

    private String clientName;

    @Override
    public void send(Socket socket,T content) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println(content);
        printStream.flush();
    }

    @Override
    public String getName() {
        return clientName;
    }

    @Override
    public void configName(String name) {
        this.clientName = name;
    }

}
