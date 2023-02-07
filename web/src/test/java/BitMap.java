import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author chase
 * @date 2023/2/4 5:52 PM
 */
@Slf4j
public class BitMap {

    final List<Integer> randomNumberList;

    byte[] bitMap;

    static char[] charNegative128 = new char[]{'1', '0', '0', '0', '0', '0', '0', '0'};

    public BitMap(List<Integer> randomNumberList) {
        this.randomNumberList = randomNumberList;
        bitMap = new byte[10000 * 10000 * 10 / Byte.SIZE];
    }


    /**
     * Integer.MAX_VALUE是2147483647,21亿
     */
    public void addAll() {
        /*
         由于是10亿个数字，可以优化下
         int index = number / 8;
         int bitOffset = number % 8;
         */
        for (Integer number : randomNumberList) {
            int index = number >> 3;
            int bitOffset = number & 0x7;
            // 这里比较特殊，余0是00000001，余1是00000010，因为一共是8位，但是余数只有7，为了统一减少运算步骤，将余0划分给一个1
            bitMap[index] |= 1 << bitOffset;
            log.debug("number: " + number + "index: " + index + "bitOffset: " + bitOffset + "bitMap[i]" + bitMap[index]);
        }
    }

    public List<Integer> getAll() {
        addAll();
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < bitMap.length; i++) {
            if (bitMap[i] != 0) {
                char[] bitOffsets = bitMap[i] == - 128 ? charNegative128 : Integer.toBinaryString(bitMap[i]).toCharArray();;
                log.debug(Arrays.toString(bitOffsets));
                for (int j = 0; j < bitOffsets.length; j++) {
                    if (bitOffsets[j] == '1') {
                        log.debug("index: " + i + " bitOffset: " + (bitOffsets.length - j));
                        numberList.add(i << 3 | (bitOffsets.length - j - 1));
                    }
                }
            }
        }
        return numberList;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(Arrays.asList(359395975));
        List<Integer> all = bitMap.getAll();
        all.forEach(System.out::println);
        // 特殊：byte的1<<7是负数，因为符号位是1了，使用Integer.toBinaryString（）时会返回32位
        byte testByte = (byte) (1 << 7);
        System.out.println(testByte);
        System.out.println(1 << 7);
//        Byte.MIN_VALUE
        List<Integer> randomNumberList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            randomNumberList.add(random.nextInt(10000 * 10000 * 10));
        }
        Collections.sort(randomNumberList);
        bitMap = new BitMap(randomNumberList);
        List<Integer> allNumberList = bitMap.getAll();
        for (int i = 0; i < randomNumberList.size(); i++) {
            System.out.println(randomNumberList.get(i) + "\t" + allNumberList.get(i));
        }

    }
}

