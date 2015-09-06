package threadTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yonney.yang on 2015/8/29.
 */
public class CacheTest {
    Map<String,Object> cache = new HashMap<String, Object>();

    public Object getData(String key){
        ReadWriteLock rw = new ReentrantReadWriteLock();
        rw.readLock().lock();
        Object value = cache.get(key);
        if (value == null){
            rw.readLock().unlock();
            rw.writeLock().lock();
            if (value == null){
                //read db&&set into map
            }
            rw.writeLock().unlock();
            rw.readLock().lock();
        }
        rw.readLock().unlock();
        return value;
    }
}
