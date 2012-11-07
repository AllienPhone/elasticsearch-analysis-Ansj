package org.ansj.splitWord.impl;

import java.io.IOException;
import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

/**
 * 针对索引的分词方式
 * 
 * @author ansj
 * 
 */
public class IndexDemo {
	public static void main(String[] args) throws IOException {
		int all = 0;
		String str = "上海市长江大桥近日到职";
		long start = System.currentTimeMillis();

		for (int i = 0; i < 1; i++) {
			all += str.length();
			List<Term> paser = IndexAnalysis.paser(str);

			for (Term term : paser) {
				System.out.println(term + "\t" + term.getOffe());
			}
		}
		System.out.println("每秒处理了:" + (all * 1000.0 / (System.currentTimeMillis() - start)));
	}
}
