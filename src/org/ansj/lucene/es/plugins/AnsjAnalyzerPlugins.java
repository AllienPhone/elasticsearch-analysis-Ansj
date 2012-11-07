package org.ansj.lucene.es.plugins;

import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.index.analysis.AnsjAnalysisBinderProcessor;
import org.elasticsearch.plugins.AbstractPlugin;

public class AnsjAnalyzerPlugins extends AbstractPlugin {
   private ESLogger esLogger;
   
   public AnsjAnalyzerPlugins()
   {
	   this.esLogger=Loggers.getLogger(AnsjAnalyzerPlugins.class);
   }
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "analysis-ansj";
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "analysis-ansj";
	}

	public void onModule(AnalysisModule module) {
		module.addProcessor(new AnsjAnalysisBinderProcessor());
		this.esLogger.info("Loading Ansj");
	}
}
