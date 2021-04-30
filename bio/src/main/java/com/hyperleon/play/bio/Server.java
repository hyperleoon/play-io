package com.hyperleon.play.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.function.Function;

/**
 * @author leon
 * @date 2021-04-30 15:14
 **/
public interface Server<T> extends NameAble {

    /**
     * obtain socket
     * @param port  target port
     * @return socket instance
     * @throws IOException io exception
     */
    Socket getSocket(Integer port) throws IOException;


    /**
     * config executor for server
     * @param executor executor service
     * @param <E> implement of ExecutorService
     */
    <E extends ExecutorService> void configProcessExecutor(E executor);


    T process(SocketTask task);

}
