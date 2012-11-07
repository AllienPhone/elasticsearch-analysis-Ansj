package org.elasticsearch.index.analysis;

import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.index.analysis.AnalysisModule.AnalysisBinderProcessor.TokenFiltersBindings;

public class AnsjAnalysisBinderProcessor extends
		AnalysisModule.AnalysisBinderProcessor {
	private ESLogger logger;

	public AnsjAnalysisBinderProcessor() {
		this.logger = Loggers.getLogger("ansj-Analysis");
	}

	@Override
	public void processAnalyzers(AnalyzersBindings analyzersBindings) {
		analyzersBindings.processAnalyzer("ansj", AnsjAnalyzerProvider.class);
		this.logger.info("processAnalyzers");
	}

	@Override
	public void processTokenizers(TokenizersBindings tokenizersBindings) {
		tokenizersBindings
				.processTokenizer("ansj", AnsjTokenizerPrivoder.class);
	}

	@Override
	public void processTokenFilters(TokenFiltersBindings tokenFiltersBindings) {

	}
}
