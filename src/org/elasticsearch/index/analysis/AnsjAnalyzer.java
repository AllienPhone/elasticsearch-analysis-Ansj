package org.elasticsearch.index.analysis;

import java.io.IOException;
import java.io.Reader;
import java.util.Set;

import org.ansj.library.UserDefineLibrary;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;

public class AnsjAnalyzer extends Analyzer {
	public Set filter;
	
	public AnsjAnalyzer(Set filter) {
	    this.filter = filter;
	}
	
	public AnsjAnalyzer(Settings settings) {
	    UserDefineLibrary.Init(settings);
	}

	@Override
	public TokenStream tokenStream(String fileName, Reader Reader) {
		try {
			return new AnsjTokenizer(Reader,filter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
