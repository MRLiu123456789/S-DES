package BaseMethodsTools;

import BaseDataTools.BaseCPTools;
import BaseDataTools.BasePasswordTools;

import java.util.ArrayList;
import java.util.List;


//加密和解密的方法。
public class CPMethods {

    /**
     * 加密铭文的方法
     * @param p 需要传入的明文
     * @param k 需要传入的密钥
     * @return c 密文
     */
    public static int[] jiami(int[] p,int[] k){
      int[] p1 = IP(p,BaseCPTools.getIP());
      //  int[] k = {2,1,0,1,0,0,0,0,0,1,0};  //一个密钥。
       int[] p2 = fk(p1,CreateKeys.createKeys(k, BasePasswordTools.getP10(),BasePasswordTools.getP8()).get(0));
       int[] p3 = fk(p2,CreateKeys.createKeys(k, BasePasswordTools.getP10(),BasePasswordTools.getP8()).get(1));
       for(int i = 1; i <= 4; i ++){
           int temp = p3[i];
           p3[i] = p3[i + 4];
           p3[i + 4] = temp;
       }

      return IPReverse(p3,BaseCPTools.getIp1());
    }

    /**
     * 解密密文的方法
     * @param c 密文
     * @param k 密钥
     * @return p 明文
     */
    public static int[] jiemi(int[] c,int[] k){
        int[] c1 = IP(c,BaseCPTools.getIP());
        //int[] k = {2,1,0,1,0,0,0,0,0,1,0};  //模拟随机生成一个密钥。
        int[] c2 = fk(c1,CreateKeys.createKeys(k, BasePasswordTools.getP10(),BasePasswordTools.getP8()).get(1));
        int[] c3 = fk(c2,CreateKeys.createKeys(k, BasePasswordTools.getP10(),BasePasswordTools.getP8()).get(0));
        for(int i = 1; i <= 4; i ++){
            int temp = c3[i];
            c3[i] = c3[i + 4];
            c3[i + 4] = temp;
        }

        return IPReverse(c3,BaseCPTools.getIp1());
    }

    /**
     * IP置换方法
     * @param p   明文
     * @param ip  ip置换表
     * @return
     */
    public static int[] IP(int[] p,int[] ip){

        int[] p1 = new int[9];
        for(int i = 0; i < 8; i ++){
            p1[i + 1] = p[ip[i]];
        }

        return p1;
    }

    /**
     * ip反置换
     * @param p  明文
     * @param ip_1 逆置换表
     * @return
     */
    public static int[] IPReverse(int[] p,int[] ip_1){

        int[] p2 = new int[9];
        for(int i = 0; i < 8; i ++){
            p2[i + 1] = p[ip_1[i]];
        }

        return p2;
    }

    public static void swap(int[]left,int[] right){
        int[] temp = new int[5];

        for(int i = 1; i <= 4; i ++ ){
            temp[i] = right[i];
            right[i] = left[i];
            left[i] = temp[i];
        }

    }

    /**
     * fk函数
     * @param p1
     * @param keys
     * @return
     */
    public static int[] fk(int[] p1, int[] keys){
        int[] left1 = new int[5];
        int[] right1 = new int[5];
        System.arraycopy(p1,1,left1,1,4);
        System.arraycopy(p1,5,right1,1,4);

        int[] epbox = BaseCPTools.getEPBox();
        int[] right2 = new int[9];

        for(int i = 0; i < 8; i ++){
            right2[i + 1] = right1[epbox[i]];
        }


        int[] key1 = keys;
        int[] right3 = new int[9];
        for(int i = 1; i <= 8; i ++){
            right3[i] = right2[i] ^ key1[i];
        }


        int[] left4 = new int[5];
        int[] right4 = new int[5];
        System.arraycopy(right3,1,left4,1,4);
        System.arraycopy(right3,5,right4,1,4);

        int[][] sbox1 = BaseCPTools.getSBox1();
        int[][] sbox2 = BaseCPTools.getSBox2();
        int[] num = new int[5];

        int row = left4[1] * 2 + left4[4];
        int col = left4[2] * 2 + left4[3];

        int num1 = sbox1[row][col];

        if(num1 == 0){
            num[1] = 0;
            num[2] = 0;
        } else if(num1 == 1){
            num[1] = 0;
            num[2] = 1;
        }else if(num1 == 2){
            num[1] = 1;
            num[2] = 0;
        }else if(num1 == 3){
            num[1] = 1;
            num[2] = 1;
        }


         row = right4[1] * 2 + right4[4];
         col = right4[2] * 2 + right4[3];

         int num2 = sbox2[row][col];

        if(num2 == 0){
            num[3] = 0;
            num[4] = 0;
        } else if(num2 == 1){
            num[3] = 0;
            num[4] = 1;
        }else if(num2 == 2){
            num[3] = 1;
            num[4] = 0;
        }else if(num2 == 3){
            num[3] = 1;
            num[4] = 1;
        }



        int[] spbox = BaseCPTools.getSPBox();
        int[] num3 = new int[5];

        for(int i = 0; i < 4; i ++){
            num3[i + 1] = num[spbox[i]];
        }

        int[] newleft = new int[5];
        for(int i = 0; i < 4; i ++){
            newleft[i + 1] = left1[i + 1] ^ num3[i + 1];
        }


       int[] newone = new int[9];
        System.arraycopy(right1,1,newone,1,4);
        System.arraycopy(newleft,1,newone,5,4);

        return newone;


    }




}
