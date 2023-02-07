import java.util.BitSet;
import java.util.HashMap;

/**
 * @author chase
 * @date 2023/2/4 4:14 PM
 */
public class BitMapTest {
    public static void main(String[] args) {
        BitSet bitSet=new BitSet();
        bitSet.set(5);

        boolean flag = bitSet.get(5);
        // 打印结果就是 flag = true
        System.out.println("flag = " + flag);
        boolean flagIndex = bitSet.get(4);
        // 打印结果就是 flagIndex = false
        System.out.println("flagIndex = " + flagIndex);


        // 实现电话号码的需求
        // 152 7092 4356 电话号码前三位都是号码段，都是固定的，所以可以使用map存储，然后剩余的几位可以放到BitSet中去
        bitSet.set(70924356);
        HashMap<String, BitSet> objectObjectHashMap = new HashMap<>(10);

        BitSet bitSet152 = objectObjectHashMap.computeIfAbsent("152", k -> new BitSet());
        // 因为bitSet只能使用Integer类型 如果只使用8个位，那么就是8乘10亿/8288608
        bitSet152.set(70924356);
        System.out.println(Integer.MAX_VALUE);
    }

}
