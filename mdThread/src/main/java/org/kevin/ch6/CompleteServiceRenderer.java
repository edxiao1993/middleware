package org.kevin.ch6;

import org.kevin.whatever.ImageData;
import org.kevin.whatever.ImageInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 比起加载完所有的图片再进行图片的渲染，
 * 这里的改进为每加载完一张图片，就立即进行渲染。
 *
 * @author Kevin.Z
 * @version 2021/7/24
 */
public class CompleteServiceRenderer {
    private final ExecutorService exec = Executors.newFixedThreadPool(33);

    void renderPage(CharSequence source){
        List<ImageInfo> info = scanForImageInfo(source);
        CompletionService<ImageData> completionService = new ExecutorCompletionService<>(exec);
        for (final ImageInfo imageInfo : info) {
            completionService.submit(new Callable<ImageData>() {
                @Override
                public ImageData call() throws Exception {
                    return imageInfo.downloadImage();
                }
            });
        }

        renderText(source);

        try{
            for (int i = 0; i < info.size(); i++) {
                // 从 completionService 中获取已经加载的图片
                Future<ImageData> f = completionService.take();
                ImageData imageData = f.get();
                renderImage(imageData);
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
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
