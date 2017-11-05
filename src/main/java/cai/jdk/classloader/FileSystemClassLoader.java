package cai.jdk.classloader;

import java.io.*;

/**
 * Created by caiyl on 2017/5/1.
 */
public class FileSystemClassLoader extends ClassLoader {



    private String path = "/home/";    //默认加载路径

    private String name;                    //类加载器名称

    private final String filetype = ".class"; //文件类型


    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        // TODO Auto-generated method stub
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) {
        byte[] data = null;
        InputStream in = null;
        name = name.replace('.', '/');
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            in = new FileInputStream(new File(path + name + filetype));
            int len = 0;
            while (-1 != (len = in.read())) {
                out.write(len);
            }
            data = out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public FileSystemClassLoader(String name) {
        super();
        this.name = name;
    }
}
