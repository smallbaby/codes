package com.jason.codepractise.datastructure;

/**
 * author: zhangkai
 * date: 2019-08-26
 * description:
 * byte用8个二进制位表示，
 * copy: https://www.jianshu.com/p/e530baada558
 */
public class BitMapJason {
    public static void main(String[] args) {
        byte[] bits = new byte[getIndex(1000000000) + 1];
        System.out.println(10>>>3);
        /**
         * 10-->
         *     1010
         *
         *
         */

    }

    /**
     * num/8得到byte[]的index
     * @param num
     * @return
     */
    public static int getIndex(int num) {
        return num >>> 3;
    }

    /**
     * 计算数字num在byte[index]的位置
     * @param num
     * @return
     */
    public static int getPosition(int num) {
        return num % 0x07;
    }

    /**
     * @param bits
     * @param num
     */
    public void add(byte[] bits, int num) {
        bits[getIndex(num)] |= 1 << getPosition(num);
    }

    /**
     * 判断指定数字是否存在
     * @param bits
     * @param num
     * @return
     */
    public boolean contains(byte[] bits, int num) {
        return (bits[getIndex(num)] & 1 << getPosition(num)) != 0;
    }

}
