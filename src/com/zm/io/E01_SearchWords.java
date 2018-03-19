package com.zm.io;

import java.io.*;
import java.util.*;

import net.mindview.util.TextFile;

public class E01_SearchWords {

	public static void main(final String [] args){
		File path=new File(".");
		String [] list;
		if (args.length==0){
			list=path.list();
		}
		else{
			list=path.list(new FilenameFilter() {
				//拿到参数，转为小写
				private String ext=args[0].toLowerCase();
				//实现accept放法
				public boolean accept(File dir, String name) {
					if(name.toLowerCase().endsWith(ext)){
						if(args.length==1){
							return true;
						}
						Set<String> words=new HashSet<String>(
								//TextFile是mindview.util中的类，不知道怎么或得
								new TextFiel(new File(dir,name).getAbsolutePath(),"\\w+");
								for(int i=1;i<args.length;i++)
									if(words.contains(args[i]))
										return true;
					}
					return false;
				}
			});
		}
			Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
			for(String dirItem:list)
				System.out.println(dirItem);
	}
}
