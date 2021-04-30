package com.hyperleon.play.bio;

import java.net.Socket;
import java.util.concurrent.Callable;

/**
 * @author leon
 * @date 2021-04-30 16:15
 **/
public abstract class SocketTask<T> implements Runnable {

    protected Socket socket;

    public SocketTask(Socket socket) {
        this.socket = socket;
    }
}
