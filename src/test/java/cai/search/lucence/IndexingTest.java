package cai.search.lucence;

import junit.framework.TestCase;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import java.io.IOException;

/**
 * Created by caiyl on 2017/1/23.
 */
public class IndexingTest extends TestCase{
    protected String[] ids = {"1","2"};
    protected String[] unindexed = {"Netherlands","Italy"};
    protected String[] unstored = {"amsterdam has lots of bridges","Venice has lots of canals"};
    protected String[] text = {"Amsterdam","Venice"};
    private Directory directory;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        directory = new RAMDirectory();
        IndexWriter writer = getWriter();

        for (int i = 0; i < ids.length; i++) {
            Document doc = new Document();
            doc.add(new Field("id",ids[i],Field.Store.YES,Field.Index.NOT_ANALYZED));
            doc.add(new Field("country",unindexed[i],Field.Store.YES,Field.Index.NO));
            doc.add(new Field("contents",unstored[i],Field.Store.NO,Field.Index.ANALYZED));
            doc.add(new Field("city",text[i],Field.Store.YES,Field.Index.ANALYZED));
            writer.addDocument(doc);
        }
        writer.close();

    }

    private IndexWriter getWriter() throws IOException{
        return new IndexWriter(directory,new WhitespaceAnalyzer(),IndexWriter.MaxFieldLength.UNLIMITED);
    }

   /* protected int getHitCount(String fieldName,String searchString) throws IOException{
        IndexSearcher searcher = new IndexSearcher(directory);
        Term t = new Term(fieldName,searchString);
        Query query = new TermQuery(t);
        int hitCount = TestUtil
    }*/

    public void testIndexWriter() throws IOException{
        IndexWriter writer = getWriter();
        assertEquals(ids.length,writer.numDocs());
        writer.close();
    }

    public void testIndexReader()throws IOException{
        IndexReader reader = IndexReader.open(directory);
        assertEquals(ids.length,reader.maxDoc());
        assertEquals(ids.length,reader.numDocs());
        reader.close();
    }

    public void testDeleteBeforeOptimize()throws IOException{
        IndexWriter writer = getWriter();
        assertEquals(2,writer.numDocs());
        writer.deleteDocuments(new Term("id","1"));
        writer.commit();
        assertTrue(writer.hasDeletions());
        assertEquals(2,writer.maxDoc());
        assertEquals(1,writer.numDocs());
        writer.close();
    }
    public void testDeleteAfterOptimize()throws IOException{
        IndexWriter writer = getWriter();
        assertEquals(2,writer.numDocs());
        writer.deleteDocuments(new Term("id","1"));
        writer.optimize();
        writer.commit();

        assertFalse(writer.hasDeletions());
        assertEquals(1,writer.maxDoc());
        assertEquals(1,writer.numDocs());
        writer.close();
    }

    public void testUpdate() throws IOException{
        IndexWriter writer = getWriter();
        Document doc = new Document();
        doc.add(new Field("id","1",Field.Store.YES,Field.Index.NOT_ANALYZED));
        doc.add(new Field("country","Netherlands",Field.Store.YES,Field.Index.NO));
        doc.add(new Field("contents","Netherlands",Field.Store.YES,Field.Index.ANALYZED));

    }
}






































































































