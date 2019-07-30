package com.personal.tools;

import java.util.Random;

/**
 * 根据ID生成邀请码的工具类
 * @author 杨鹏
 */
public class ShareCodeUtil {
    /** 自定义进制(0,1没有加入,容易与o,l混淆) */
    private static final char[] RANDOM_CHAR=new char[]{'Q', 'W', 'E', '8', 'A', 'S', '2', 'D', 'Z', 'X', '9', 'C', '7', 'P', '5', 'I', 'K', '3', 'M', 'J', 'U', 'F', 'R', '4', 'V', 'Y', 'l', 'T', 'N', '6', 'B', 'G', 'H'};

    /** (不能与自定义进制有重复) */
    private static final char BINARY='O';

    /** 进制长度 */
    private static final int BIN_LEN=RANDOM_CHAR.length;

    /** 序列最小长度 */
    private static final int MIN_SERIAL=6;

    /**
     * 根据ID生成六位随机码
     * @param id ID
     * @return 随机码
     */
    public static String toSerialCode(long id) {
        char[] buf=new char[32];
        int charPos=32;

        while((id / BIN_LEN) > 0) {
            int ind=(int)(id % BIN_LEN);
            buf[--charPos]=RANDOM_CHAR[ind];
            id /= BIN_LEN;
        }
        buf[--charPos]=RANDOM_CHAR[(int)(id % BIN_LEN)];
        String str=new String(buf, charPos, (32 - charPos));
        // 不够长度的自动随机补全
        if(str.length() < MIN_SERIAL) {
            StringBuilder sb=new StringBuilder();
            sb.append(BINARY);
            Random rnd=new Random();
            for(int i=1; i < MIN_SERIAL - str.length(); i++) {
                sb.append(RANDOM_CHAR[rnd.nextInt(BIN_LEN)]);
            }
            str+=sb.toString();
        }
        return str;
    }

    public static long codeToId(String code) {
        char[] chs=code.toCharArray();
        long res=0L;
        for(int i=0; i < chs.length; i++) {
            int ind=0;
            for(int j=0; j < BIN_LEN; j++) {
                if(chs[i] == RANDOM_CHAR[j]) {
                    ind=j;
                    break;
                }
            }
            if(chs[i] == BINARY) {
                break;
            }
            if(i > 0) {
                res=res * BIN_LEN + ind;
            } else {
                res=ind;
            }
        }
        return res;
    }

   public static void main(String[] args) {
       String s = toSerialCode(16);
       System.out.println(s);
       System.out.println(codeToId(s));
   }

}
