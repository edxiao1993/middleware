package org.kevin.ch5;

import org.kevin.whatever.Computable;

import java.util.concurrent.*;

/**
 * @author Kevin.Z
 * @version 2021/7/24
 */
public class Memorizer<A, V> implements Computable<A, V> {
    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memorizer(Computable<A, V> c){
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        while(true){
            Future<V> f = cache.get(arg);
            if(f == null){
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<>(eval);
                f = cache.putIfAbsent(arg, ft);
                if(f == null){
                    f = ft;
                    ft.run();
                }
            }
            try{
                return f.get();
            } catch (CancellationException e){
                cache.remove(arg, f);
            } catch (ExecutionException e){
                e.printStackTrace();
            }

        }
    }
}
