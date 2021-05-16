package org.kevin.service;

/**
 * @author Kevin.Z
 * @version 2021/5/17
 */
public interface RedisService {

    /**
     * 1. generate a key everyday
     * 2. add the key and userId: pfadd key userId  --
     * 3. count: pfcount
     *
     * @param key
     * @param obj
     * @return
     */
    boolean addHyperloglog(String key, Object obj);

    long hyperCount(String key);
}
