package com.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 工具类---文件类
 * @author Administrator
 *
 */
public class TestFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File("D:\\a.txt");
		System.out.println(file);
		file.renameTo(new File("D:\\b.txt"));
		
		System.out.println(System.getProperty("user.dir"));
		
		File file2 = new File("gg.txt");
//		file2.createNewFile();
		
		System.out.println("File是否存在："+file2.exists());
        System.out.println("File是否是目录："+file2.isDirectory());
        System.out.println("File是否是文件："+file2.isFile());
        System.out.println("File最后修改时间："+new Date(file2.lastModified()));
        System.out.println("File的大小："+file2.length());
        System.out.println("File的文件名："+file2.getName());
        System.out.println("File的相对目录路径："+file2.getPath());
        System.out.println("File的绝对目录路径："+file2.getAbsolutePath());
        
        File f = new File("d:/c.txt");
        f.createNewFile(); // 会在d盘下面生成c.txt文件
        f.delete(); // 将该文件或目录从硬盘上删除
        File f2 = new File("d:/电影/华语/大陆");
        boolean flag = f2.mkdir(); //目录结构中有一个不存在，则不会创建整个目录树
        System.out.println(flag);//创建失败
        
        flag = f2.mkdirs();//目录结构中有一个不存在也没关系；创建整个目录树
        System.out.println(flag);//创建成功
	}
}
