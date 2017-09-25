package com.vega.springmvc.app;

import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.vega.springmvc.config.ApplicationConfig;

public class AppStore {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GridFsOperations operation = (GridFsOperations) ctx.getBean("gridFsTemplate");

		DBObject dbObj = new BasicDBObject();
		dbObj.put("son", "nguyen van b");
		dbObj.put("daughter", "Tran thi C");

		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream("C:/Users/khoenv/Downloads/Musics.rar");
			String id = operation.store(inputStream, "Musics", "rar/file", dbObj).getId().toString();
			System.out.println(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		((AnnotationConfigApplicationContext)ctx).close();
	}
}
