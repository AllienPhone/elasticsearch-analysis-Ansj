package org.ansj.splitWord.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.elasticsearch.index.analysis.AnsjAnalyzer;

/**
 * 标注的分词方式,这里面的流你可以传入任何流.除了流氓
 * 
 * @author ansj
 * 
 */
public class Demo {
	public static void main(String[] args) throws IOException {
		// Analysis udf = new ToAnalysis(new
		// StringReader("孙健用java重写了张华平老师的分词."));
		// Term term = null ;
		// while((term=udf.next())!=null){
		// System.out.print(term.getName()+" ");
		// }

		//AnsjAnalyzerProvider analyzerProvider = new AnsjAnalyzerProvider(null,null, null, null);
		Directory directory = FSDirectory.open(new File("E:\\aaa\\"));   
		Set<String> set=new HashSet();
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_33, new AnsjAnalyzer(set));   
        config.setOpenMode(OpenMode.CREATE_OR_APPEND);   
        IndexWriter writer = new IndexWriter(directory, config);   
        String [] array_content = {"在泽州县彤康食品有限公司", "屠宰加工项目建成投产", "比如肉制品均来自双汇", "雨润等大型肉类生产商"};   
        String [] array_name = {"泽州", "屠宰", "肉制品", "肉类生产商"};   
        for (int i = 0; i < 4; i++) {   
            Document document = new Document();   
            document.add(new Field("id", String.valueOf(i), Field.Store.YES, Field.Index.NOT_ANALYZED, Field.TermVector.YES));   
            document.add(new Field("name", array_name[i], Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.YES));   
            document.add(new Field("content", array_content[i], Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.YES));   
            writer.addDocument(document);   
        }   
        writer.optimize();   
        writer.close();       		
	}
}
