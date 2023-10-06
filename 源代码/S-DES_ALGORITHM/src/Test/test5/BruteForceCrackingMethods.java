package Test.test5;

import BaseMethodsTools.CPMethods;

import java.util.Arrays;

public class BruteForceCrackingMethods {

    /**
     * 用来破解密钥的函数并用来验证是否存在多个正确的密钥
     */
    public static void CrackMethod(){
        int[] p = {2,1,0,0,1,1,0,1,0};
        int[] c = {0,1,1,1,0,1,1,1,1};
        int count = 0;

        for (int i = 0; i < 1024; i++) {
            String binary = String.format("%10s", Integer.toBinaryString(i)).replace(' ', '0');
            int[] binaryArray = new int[10];
            for (int j = 0; j < binary.length(); j++) {
                binaryArray[j] = binary.charAt(j) - '0';
            }
            int[] key = new int[11];
            key[0] = 2;
            System.arraycopy(binaryArray,0,key,1,10);
            int[] c1 = CPMethods.jiami(p,key);
         /*   if(binary.equals("1010000010")){
                for(int j = 0; j <= 8; j ++){
                    System.out.println(c1[j] + " ");
                }
            }*/
            if(Arrays.equals(c,c1)){
                System.out.println("密钥已找到" + binary);
                count ++;
            }
        }

        if(count == 0){
            System.out.println("没有合适的密钥");
        }
    }


   /* 1 1 1 0 1 1 1 1
            1 0 0 1 1 0 1 0*/
}
