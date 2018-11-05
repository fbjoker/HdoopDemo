package com.alex.demo.mapreduce.demo;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
	int sum;
	IntWritable v =new IntWritable();
	@Override
	protected void reduce(Text key, Iterable<IntWritable> value,
			Context context) throws IOException, InterruptedException {
		
		
		sum=0;
		for (IntWritable c : value) {
			sum+=c.get();
			
		}
		v.set(sum);
		context.write(key,v);
		
		
		
		
	}
	
	
}
