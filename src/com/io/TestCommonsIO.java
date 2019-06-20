package com.io;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class TestCommonsIO {
	
	public static void main(String[] args) throws IOException {
		
		//文件大小
		long len = FileUtils.sizeOf(new File("src/com/io/TestCommonsIO.java"));
		System.out.println(len);
		
		//目录大小
		len = FileUtils.sizeOf(new File("D:/workspace/xiaozhijun/JavaProgram"));
		System.out.println(len);
		
		Collection<File> files =FileUtils.listFiles(new File("D:\\java300\\IO_study04"),
				EmptyFileFilter.NOT_EMPTY, null);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("---------------------");
		 files =FileUtils.listFiles(new File("D:\\java300\\IO_study04"),
					EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("---------------------");
		 files =FileUtils.listFiles(new File("D:\\java300\\IO_study04"),
					new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("---------------------");
		 files =FileUtils.listFiles(new File("D:\\java300\\IO_study04"),
					FileFilterUtils.or(new SuffixFileFilter("java"),
							new SuffixFileFilter("class"),EmptyFileFilter.EMPTY), DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		
		System.out.println("---------------------");
		 files =FileUtils.listFiles(new File("D:\\java300\\IO_study04"),
					FileFilterUtils.and(new SuffixFileFilter("java"),
							EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		
		//读取文件
		String msg =FileUtils.readFileToString(new File("emp.txt"),"UTF-8");
		System.out.println(msg);
		byte[] datas = FileUtils.readFileToByteArray(new File("emp.txt"));
		System.out.println(datas.length);
		
		//逐行读取
		 List<String> msgs= FileUtils.readLines(new File("emp.txt"),"UTF-8");
		 for (String string : msgs) {
			System.out.println(string);
		}
		LineIterator it =FileUtils.lineIterator(new File("emp.txt"),"UTF-8");
		while(it.hasNext()) {
			System.out.println(it.nextLine());
		}
		
		//写出文件
		FileUtils.write(new File("happy.sxt"), "学习是一件伟大的事业\r\n","UTF-8");
		FileUtils.writeStringToFile(new File("happy.sxt"), "学习是一件辛苦的事业\r\n","UTF-8",true);
		FileUtils.writeByteArrayToFile(new File("happy.sxt"), "学习是一件幸福的事业\r\n".getBytes("UTF-8"),true);
		
		//写出列表
		List<String> datas2 =new ArrayList<String>();
		datas2.add("马云");
		datas2.add("马化腾");
		datas2.add("弼马温");
		
		FileUtils.writeLines(new File("happy.sxt"), datas2,"。。。。。",true);
		
		//复制文件
		//FileUtils.copyFile(new File("p.png"),new File("p-copy.png"));
		//复制文件到目录
		//FileUtils.copyFileToDirectory(new File("p.png"),new File("lib"));
		//复制目录到目录
		//FileUtils.copyDirectoryToDirectory(new File("lib"),new File("lib2"));
		//复制目录
		//FileUtils.copyDirectory(new File("lib"),new File("lib2"));
		//拷贝URL内容
		//String url = "https://pic2.zhimg.com/v2-7d01cab20858648cbf62333a7988e6d0_qhd.jpg";
		//FileUtils.copyURLToFile(new URL(url), new File("marvel.jpg"));
		String datas3 =IOUtils.toString(new URL("http://www.163.com"), "gbk");
		System.out.println(datas3);
	}

}
