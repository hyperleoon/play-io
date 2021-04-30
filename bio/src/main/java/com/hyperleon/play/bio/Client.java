package com.hyperleon.play.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * @author leon
 * @date 2021-04-30 15:15
 **/
public interface Client<T> extends NameAble {

    /**
     * send request
     * @param socket
     * @param content
     * @throws IOException
     */
    void send(Socket socket,T content) throws IOException;
}
