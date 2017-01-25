package cai.search.lucence;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;

/**
 * Created by caiyl on 2017/1/22.
 */
public class Searcher {

    public static void main(String[] args) throws Exception {
    /*    if (args.length != 2) {
            throw new IllegalArgumentException("Usage:java " +
                    Searcher.class.getName()+" <index dir> <query>");
        }

        String indexDir = args[0];
        String q = "create";*/
        String indexDir = "F:\\learn\\dataIndex";
        String q = "14";

        search(indexDir,q);

    }

    private static void search(String indexDir, String q) throws IOException,ParseException {
        Directory dir = FSDirectory.open(new File(indexDir));
        IndexSearcher is = new IndexSearcher(dir);
        QueryParser parser = new QueryParser(Version.LUCENE_30,"contents",
                new StandardAnalyzer(Version.LUCENE_30
                ));


        Query query = parser.parse(q);
        long start = System.currentTimeMillis();
        TopDocs hits = is.search(query,10);

        long end = System.currentTimeMillis();
        System.err.println("found " + hits.totalHits + " docment(s) (in " + (end -start)
        + " milliseconds ) that match query '" + q + "'");

        for (ScoreDoc scoreDoc : hits.scoreDocs) {
            Document doc = is.doc(scoreDoc.doc);
            System.out.println(doc.get("fullpath"));
        }
        is.close();
    }

}












































































































