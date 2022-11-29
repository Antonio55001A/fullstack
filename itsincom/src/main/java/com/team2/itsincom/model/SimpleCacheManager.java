package com.team2.itsincom.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


// da fare, per ora non serve a nulla. Per prossimi aggiornamenti

public class SimpleCacheManager {

	private static SimpleCacheManager instance;
    private static Object monitor = new Object();
    private Map<String, Object> cache = Collections.synchronizedMap(new HashMap<String, Object>());
    
    String key = "";
    
    Object value;

  /*  public SimpleCacheManager(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
    }*/
    private SimpleCacheManager() {
    }

    public void put(String cacheKey, Object value) {
        cache.put(cacheKey, value);
    }

    public Object get(String cacheKey) {
        return cache.get(cacheKey);
    }

    public void clear(String cacheKey) {
        cache.put(cacheKey, null);
    }

    public void clear() {
        cache.clear();
    }

    public static SimpleCacheManager getInstance() {
        if (instance == null) {
            synchronized (monitor) {
                if (instance == null) {
                    instance = new SimpleCacheManager();
                }
            }
        }
        return instance;
    }
}
