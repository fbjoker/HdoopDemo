package com.alex.demo.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HadoopApi {
	
	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
		
		
		Configuration conf = new Configuration();
		
		FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:9000"), conf, "alex");
		
		fs.copyFromLocalFile(new Path("c:/xxx"), new Path("/temp"));
		
		
		fs.copyToLocalFile(new Path("/temp"), new Path("c:/ttt"));
		
		fs.close();
	}

}
