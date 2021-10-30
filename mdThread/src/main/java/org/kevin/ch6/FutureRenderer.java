package org.kevin.ch6;

import org.kevin.whatever.ImageData;
import org.kevin.whatever.ImageInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 将图片与文字的渲染独立出来。
 * 获取所有的图片的同时，渲染文字。
 * 在所有图片都获取完毕后，渲染图片。
 * Future.get() 会阻塞线程。
 *
 * @author Kevin.Z
 * @version 2021/7/24
 */
public class FutureRenderer {
    private final ExecutorService exec = Executors.newFixedThreadPool(33);

    void renderPage(CharSequence source){
        final List<ImageInfo> imageInfos = scanForImageInfo(source);
        final Callable<List<ImageData>> task = () -> {
            List<ImageData> result = new ArrayList<>();
            for (ImageInfo imageInfo : imageInfos) {
                result.add(imageInfo.downloadImage());
            }
            return result;
        };

        Future<List<ImageData>> future = exec.submit(task);
        renderText(source);

        try{
            List<ImageData> imageData = future.get();
            for (ImageData imageDatum : imageData) {
                renderImage(imageDatum);
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            future.cancel(true);
        } catch (ExecutionException e){
            e.printStackTrace();
        }
    }

    private void renderText(CharSequence source){

    }
    private void renderImage(ImageData id){

    }

    private List<ImageInfo> scanForImageInfo(CharSequence source){
        return null;
    }
}
