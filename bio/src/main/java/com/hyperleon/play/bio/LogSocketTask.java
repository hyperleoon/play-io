package com.hyperleon.play.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author leon
 * @date 2021-04-30 15:41
 **/
public class LogSocketTask<T> extends SocketTask<T> {

    public LogSocketTask(Socket socket) {
        super(socket);
    }

    @Override
    public void run() {
        String msg = null;
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((msg = reader.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
