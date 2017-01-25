package cai.search.lucence;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by caiyl on 2017/1/22.
 */
public class Indexer {

    private  IndexWriter writer;

    public Indexer(String indexDir) throws IOException {
        Directory dir = FSDirectory.open(new File(indexDir));
        writer = new IndexWriter(dir,new StandardAnalyzer(Version.LUCENE_30),true,
                IndexWriter.MaxFieldLength.UNLIMITED);
    }
    public void close()throws IOException{
        writer.close();
    }

    public static void main(String[] args) throws Exception{
        /*if (args.length != 2){
            throw new IllegalArgumentException("User java " + Indexer.class.getName()
            +" <index dir> <data dr>");
        }

        String indexDir =args[0];
        String dataDir =args[1];*/

        String indexDir ="F:\\learn\\dataIndex";
        String dataDir ="F:\\tmp";

        long start = System.currentTimeMillis();
        Indexer indexer = new Indexer(indexDir);
        int numIndexed;

        try {
            numIndexed = indexer.index(dataDir,new TextFilesFilter());
        }finally {
            indexer.close();
        }
    }

    public int index(String dataDir,FileFilter filter) throws Exception{
        File[] files = new File(dataDir).listFiles();
        for (File file : files) {
             if( !file.isDirectory() &&
                     !file.isHidden()&&
                     file.exists()&&
                     file.canRead()&&
                     (filter == null || filter.accept(file))){
                 indexFile(file);

             }

        }
        return writer.numDocs();
    }

    private static class TextFilesFilter implements FileFilter{

        @Override
        public boolean accept(File pathname) {
            return pathname.getName().toLowerCase().endsWith(".txt");
        }
    }

    private void indexFile(File f) throws Exception{
        System.out.println("Indexing "+f.getCanonicalPath());
        Document doc = getDocument(f);
        writer.addDocument(doc);
    }

    protected Document getDocument(File f)throws Exception{
        Document doc = new Document();

        doc.add(new Field("contents",new FileReader(f)));
        doc.add(new Field("filename",f.getName(),Field.Store.YES,Field.Index.NOT_ANALYZED));
        doc.add(new Field("fullpath",f.getCanonicalPath(),Field.Store.YES,Field.Index.NOT_ANALYZED));


        return doc;
    }
}











































































