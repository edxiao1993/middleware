package org.kevin.ch2;

import org.kevin.annotation.GuardedBy;
import org.kevin.annotation.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 缓存最近执行因数分解的数值及其计算结果的 Servlet
 *
 * @author Kevin.Z
 * @version 2021/7/24
 */
@ThreadSafe
public class CachedFactorizer implements Servlet {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;
    @GuardedBy("this")
    private long hits;
    @GuardedBy("this")
    private long cacheHits;

    public synchronized long getHits(){
        return hits;
    }

    public synchronized double getCacheHitRatio(){
        return (double) cacheHits / (double) hits;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = null;
        synchronized (this){
            ++hits;
            if(i.equals(lastNumber)){
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if(factors == null){
            factors = factor(i);
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
    }

    private BigInteger extractFromRequest(ServletRequest req){
        return new BigInteger("333");
    }
    private BigInteger[] factor(BigInteger i){
        return null;
    }



    @Override
    public void init(ServletConfig config) throws ServletException {

    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public String getServletInfo() {
        return null;
    }
    @Override
    public void destroy() {

    }
}
