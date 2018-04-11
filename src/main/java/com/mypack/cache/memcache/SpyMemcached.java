package com.mypack.cache.memcache;

import java.net.InetSocketAddress;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.BinaryConnectionFactory;
import net.spy.memcached.MemcachedClient;

public class SpyMemcached {
	//Extract memcached.zip file in out of project folder from misc folder and then start memcache by clicking on memcache.exe file.
	public static void main(String arr[]) throws Exception {
		
		MemcachedClient c =  new MemcachedClient(new BinaryConnectionFactory(), AddrUtil.getAddresses("127.0.0.1:11211"));
		//MemcachedClient c =  new MemcachedClient(new InetSocketAddress("localhost", 11211));
		c.set("SACHARYA:5d41402abc4b2a76b9719d91101", 3, "Imran Khan");//Here integer represent time in second of object life
		Thread.sleep(2000);
       System.out.println(c.get("SACHARYA:5d41402abc4b2a76b9719d91101"));
       c.shutdown();
	}
}
