package com.mypack.cache.memcache;

import java.util.ArrayList;
import java.util.List;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.BinaryConnectionFactory;
import net.spy.memcached.MemcachedClient;

public class SpyMemcached {
	//Extract memcached.zip file from misc folder in the project and then start memcache by clicking on memcache.exe file.
	public static void main(String arr[]) throws Exception {
		
		//MemcachedClient cache =  new MemcachedClient(new BinaryConnectionFactory(), AddrUtil.getAddresses("127.0.0.1:11211"));
		List<String> serverList = new ArrayList<>();
		serverList.add("127.0.0.1:11211");
		MemcachedClient cache =  new MemcachedClient(new BinaryConnectionFactory(), AddrUtil.getAddresses(serverList));
		//MemcachedClient c =  new MemcachedClient(new InetSocketAddress("localhost", 11211));
		cache.set("SACHARYA:5d41402abc4b2a76b9719d91101", 3, "Imran Khan");//Here integer represent time in second of object life
		Thread.sleep(2000);
       System.out.println(cache.get("SACHARYA:5d41402abc4b2a76b9719d91101"));
       cache.shutdown();
	}
}
