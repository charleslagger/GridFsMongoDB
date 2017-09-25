package com.vega.springmvc.app;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;

import com.mongodb.gridfs.GridFSDBFile;
import com.vega.springmvc.config.ApplicationConfig;

public class AppRead {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		GridFsOperations operation = (GridFsOperations) ctx.getBean("gridFsTemplate");

//		List<GridFSDBFile> files = operation.find(null);
//		List<GridFSDBFile> files = operation.find(new Query().addCriteria(Criteria.where("filename").is("Musics")));
//		operation.delete(new Query().addCriteria(Criteria.where("_id").is("59c8bac68c6dfe3672db2fb9")));
//		GridFSDBFile file = operation.findOne(new Query().addCriteria(Criteria.where("_id").is("59c8bac68c6dfe3672db2fb9")));
//		for (GridFSDBFile file : files) {
//			try {
//				System.out.println(file.getFilename());
//				file.writeTo("C:/Users/khoenv/Downloads/Musics.zip");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		GridFsResource[] gridFsResource = operation.getResources("img*");
		for (GridFsResource file : gridFsResource) {
			
				System.out.println(file.getFilename());
//				file.writeTo("C:/Users/khoenv/Downloads/Musics.zip");
			
		}
//		System.out.println(file.getFilename());

		((AnnotationConfigApplicationContext) ctx).close();

	}
}
