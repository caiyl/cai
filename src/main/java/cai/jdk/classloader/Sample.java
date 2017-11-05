package cai.jdk.classloader;

import java.lang.reflect.Method;

/**
 * Created by caiyl on 2017/5/1.
 */
public class Sample {
    private Sample instance;

    public void setSample(java.lang.Object instance) {
        this.instance = (Sample) instance;
    }

    public static void main(String[] args) {

    }

    public void testClassIdentity() {
        String classDataRootPath = "C:\\workspace\\Classloader\\classData";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
        String className = "com.example.Sample";
        try {
            Class<?> class1 = fscl1.loadClass(className);
            java.lang.Object obj1 = class1.newInstance();
            Class<?> class2 = fscl2.loadClass(className);
            java.lang.Object obj2 = class2.newInstance();
            Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
            setSampleMethod.invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
