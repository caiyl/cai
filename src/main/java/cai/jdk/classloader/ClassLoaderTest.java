package cai.jdk.classloader;

/**
 * Created by caiyl on 2017/5/1.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader classLoader = new FileSystemClassLoader("Myloader");
        classLoader.setPath("F:\\privateprojects\\cai\\target\\classes\\");
        Class<?> clazz = classLoader.findClass("cai.jdk.classloader.Object");

    }
}
