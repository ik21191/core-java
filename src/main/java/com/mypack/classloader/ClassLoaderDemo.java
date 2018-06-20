package com.mypack.classloader;

import java.net.URL;
import java.util.Map;

import org.apache.log4j.Logger;

class MyClassLoader extends ClassLoader {
	@Override
	protected URL findResource(String name) {
		// TODO Auto-generated method stub
		return super.findResource(name);
	}
}

public class ClassLoaderDemo {
	private static final Logger log = Logger.getLogger(ClassLoaderDemo.class);
	public static void main(String[] args) {
		log.info("ClassLoader: " + ClassLoaderDemo.class.getClassLoader());
		log.info("ParentClassLoader: " + ClassLoaderDemo.class.getClassLoader().getParent());
		
		log.info("ClassLoader: " + Map.class.getClassLoader());
	}
}
