package org.kevin.ch5;

import org.kevin.whatever.DataLoadException;
import org.kevin.whatever.ProductInfo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 通过提前启动一个线程，来计算需要耗费很长时间的运算。
 * future.get() 会阻塞线程
 *
 * @author Kevin.Z
 * @version 2021/7/24
 */
public class FutureTaskTester {
    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(() -> {
        return loadProductInfo();
    });
    private final Thread thread = new Thread(future);

    public void start(){
        thread.start();
    }

    public ProductInfo get() throws InterruptedException, DataLoadException{
        try{
            return future.get();
        } catch (ExecutionException e){
            Throwable cause = e.getCause();
            if(cause instanceof DataLoadException){
                throw (DataLoadException) cause;
            } else {
                throw new InterruptedException();
            }
        }
    }

    private ProductInfo loadProductInfo(){
        return new ProductInfo();
    }
}
