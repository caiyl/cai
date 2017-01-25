package cai.search.lucence;

import junit.framework.TestCase;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

/**
 * Created by caiyl on 2017/1/23.
 */
public class LockTest extends TestCase {
    private Directory dir;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        String indexDir = System.getProperty("java.io.tmpdir","tmp")
                + "index";
        dir = FSDirectory.open(new File(indexDir));
    }

    public void testWriteLock() throws IOException{
        IndexWriter writer1 = new IndexWriter(dir,new SimpleAnalyzer(),IndexWriter.MaxFieldLength.UNLIMITED);
        IndexWriter writer2 = null;
        try{
            writer2 = new IndexWriter(dir,new SimpleAnalyzer(),IndexWriter.MaxFieldLength.UNLIMITED);
            fail("we should never reach this point");
        }catch (LockObtainFailedException e){
            e.printStackTrace();
        }finally {
            writer1.close();
            assertNull(writer2);
        }
    }


}



















































