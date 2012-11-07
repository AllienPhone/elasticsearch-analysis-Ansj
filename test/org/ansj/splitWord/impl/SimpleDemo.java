package org.ansj.splitWord.impl;

import java.io.IOException;
import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

/**
 * 最最最简单的分词调用方式
 * @author ansj
 *
 */
public class SimpleDemo {
	public static void main(String[] args) throws IOException {
		ToAnalysis.paser("init 123 孙建");
		int all =0 ;
		String str = "江苏新宁" ;
		long start = System.currentTimeMillis() ;
		
		for (int i = 0; i < 1; i++) {
			all += str.length() ;
			List<Term> xList=ToAnalysis.paser(str);
			xList=null;
		}
		System.out.println("每秒处理了:"+(all*1000.0/(System.currentTimeMillis()-start)));
	}
}
