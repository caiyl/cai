package cai.jdk.classloader;

/**
 * Created by caiyl on 2017/4/30.
 */
public class ClassLoadTree{
    public static void main(String[] args) {
        ClassLoader loader = ClassLoadTree.class.getClassLoader();
        if (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }
}
