package org.elasticsearch.index.analysis;

import java.io.Reader;

import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.AbstractTokenizerFactory;
import org.elasticsearch.index.settings.IndexSettings;

public class AnsjTokenizerPrivoder extends AbstractTokenizerFactory {

	@Inject
	public AnsjTokenizerPrivoder(Index index, @IndexSettings Settings indexSettings, @Assisted String name, @Assisted Settings settings) {
		super(index, indexSettings, name, settings);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Tokenizer create(Reader reader) {
		// TODO Auto-generated method stub
		return new AnsjTokenizer(reader,null);
	}
}
