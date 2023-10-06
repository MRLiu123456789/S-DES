package BaseMethodsTools;

import BaseDataTools.BasePasswordTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//生成密钥的方法。
public class CreateKeys {

    /**
     *
     * @param k  传入的密钥
     * @param p10  p10盒子
     * @param p8  p8 盒子
     * @return  两个新的密钥
     */
    public static List<int []> createKeys(int[] k, int[] p10, int[] p8){
        int[] ks = new int[k.length];
        for (int i = 0; i < 10; i++) {
            ks[i + 1] = k[p10[i]];              //争取输入的时候从k[1]开始读取
        }

        int[] kl = new int[6];    //分成左右两部分
        int[] kr = new int[6];

        System.arraycopy(ks,1,kl,1, 5);
        System.arraycopy(ks,6,kr,1, 5);

        int[]ls = BasePasswordTools.getLeftShift1();
        int[] kl1 = new int[6];
        int[] kr1 = new int[6];
        for(int i = 0; i < 5; i ++){                        //将左右两部分各自左移一位
            kl1[i + 1] = kl[ls[i]];
            kr1[i + 1] = kr[ls[i]];
        }

        int[] ks1 = new int[11];
         System.arraycopy(kl1,1,ks1,1,5);     //重新合并成一个数组
         System.arraycopy(kr1,1,ks1,6,5);

         int[] k1 = new int[9];

       for(int i = 0; i < 8; i ++){                                              //生成k1密钥
           k1[i + 1] = ks1[p8[i]];
       }

       int[] ls2 = BasePasswordTools.getLeftShift2();                            //左移二位

        for(int i = 0; i < 5; i ++){
            kl1[i + 1] = kl[ls2[i]];
            kr1[i + 1] = kr[ls2[i]];
        }


        System.arraycopy(kl1,1,ks1,1,5);      //重新合并成一个数组
        System.arraycopy(kr1,1,ks1,6,5);

        int[] k2 = new int[9];
        for(int i = 0; i < 8; i ++){                                             //生成k2密钥
            k2[i + 1] = ks1[p8[i]];
        }

        List<int[]> keys = new ArrayList<>();                                   //将k1和k2两个密钥打包
      keys.add(k1);
       keys.add(k2);


        return keys;
    }

}
