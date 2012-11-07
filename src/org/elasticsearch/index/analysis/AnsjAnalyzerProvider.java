package org.elasticsearch.index.analysis;

import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;
import org.elasticsearch.index.settings.IndexSettings;

public class AnsjAnalyzerProvider extends
		AbstractIndexAnalyzerProvider<AnsjAnalyzer> {
	private final AnsjAnalyzer analyzer;
	private ESLogger esLogger;

	@Inject
	public AnsjAnalyzerProvider(Index index, @IndexSettings Settings indexSettings, Environment env, @Assisted String name, @Assisted Settings settings) {
		super(index, indexSettings, name, settings);
		// TODO Auto-generated constructor stub
		this.analyzer = new AnsjAnalyzer(indexSettings);
		this.esLogger=Loggers.getLogger(AnsjAnalyzerProvider.class);
	}

	@Override
	public AnsjAnalyzer get() {
		// TODO Auto-generated method stub
		this.logger.info("Request Analyzer Object");
		return this.analyzer;
	}
}
