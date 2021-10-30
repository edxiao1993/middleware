package org.kevin.ch6;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * @author Kevin.Z
 * @version 2021/7/24
 */
public class LifecycleWebServer {
    private final int nThreads = 33;
    private final ExecutorService exec = Executors.newFixedThreadPool(nThreads);

    public void start() throws IOException{
        ServerSocket socket = new ServerSocket(8888);
        while(!exec.isShutdown()){
            try{
                final Socket conn = socket.accept();
                exec.execute(() -> {
                    handleRequest(conn);
                });
            } catch (RejectedExecutionException e){
                if (!exec.isShutdown()){
                    System.out.println("sth. wrong");
                }
            }
        }
    }

    public void stop(){
        exec.shutdown();
    }

    public void handleRequest(Socket conn){
        HttpServletRequest req = readRequest(conn);
        if(isShutdownRequest(req)){
            stop();
        } else {
            dispatcher();
        }
    }

    private HttpServletRequest readRequest(Socket socket){
        return null;
    }
    private void dispatcher(){}
    private boolean isShutdownRequest(HttpServletRequest req){
        return true;
    }
}
