package cai.jdk.memory;

import org.openjdk.jol.info.ClassLayout;

/**
 * 参考：https://www.jianshu.com/p/194b745884a5 https://www.jianshu.com/p/6d62c3ee48d0
 * JVM中一个对象包含3个部分：对象头、实例数据和对齐填充 （数组对象还有一个长度）
 * 原生类型的内存占用情况如下：
 * boolean 1
 * byte 1
 * short 2
 * char 2
 * int 4
 * float 4
 * long 8
 * double 8
 *
 * jvm参数 -XX:+UseCompressedOops
 *
 */
public class ObjectMemory {
    public static void main(String[] args) {
        AAAAA A = new AAAAA();
        System.out.println(ClassLayout.parseInstance(A).toPrintable());
        BBBBB B = new BBBBB();
        System.out.println(ClassLayout.parseInstance(B).toPrintable());
        CCCCC C = new CCCCC();
        System.out.println(ClassLayout.parseInstance(C).toPrintable());
        DDDDD D = new DDDDD();
        System.out.println(ClassLayout.parseInstance(D).toPrintable());
        int[] E = new int[0];
        System.out.println(ClassLayout.parseInstance(E).toPrintable());
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
    }
}

class AAAAA {
}

class BBBBB {
    int a = 1;
}

class CCCCC {
    long a = 1L;
}

class DDDDD {
    String s = "hello";
}