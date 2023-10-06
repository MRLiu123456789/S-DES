import BaseDataTools.BaseCPTools;
import BaseDataTools.BasePasswordTools;
import BaseMethodsTools.CPMethods;
import BaseMethodsTools.CreateKeys;
import Test.test5.BruteForceCrackingMethods;

import java.util.List;

import static BaseMethodsTools.CPMethods.jiemi;

public class Main {
    public static void main(String[] args) {

        /*    测试密钥能否正确的生成。
        int[] k = {2,1,0,1,0,0,0,0,0,1,0};
       List<int[]> keys = CreateKeys.createKeys(k, BasePasswordTools.getP10(),BasePasswordTools.getP8());
       int[] k1 = keys.get(0);
       for(int i = 1; i <= 8; i++){
           System.out.print(k1[i] + " ");
       }*/

        /*   测试fk函数的正确性。
        int[] k = {2,1,0,1,0,0,0,0,0,1,0};
        List<int[]> keys = CreateKeys.createKeys(k, BasePasswordTools.getP10(),BasePasswordTools.getP8());
        int[] p = {2,1,0,0,1,1,0,1,0};
        int[] p1 = CPMethods.IP(p,BaseCPTools.getIP());
        int[] p2 = CPMethods.fk(p1,keys.get(0));
        for(int i = 1; i <= 8; i ++){
            System.out.print(p2[i] + " ");
        }
*/

/*     测试swap函数的正确性。
        int[] a1 = {0,1,2,3,4};
        int[] a2 = {5,6,7,8,9};

        CPMethods.swap(a1,a2);

        for(int i = 1; i <= 4; i ++){
            System.out.print(a1[i] + " ");
        }
        System.out.println();

        for(int i = 1; i <= 4; i ++){
            System.out.print(a2[i] + " ");
        }
        System.out.println();
    }
    */
/*
       int[] p = {2,1,0,0,1,1,0,1,0};         //需要加密的数据                     测试
        int[] k = {2,1,0,1,0,0,0,0,0,1,0};     //一个密钥
        int[] c =CPMethods.jiami(p,k);
        for(int i = 1; i <= 8; i ++){
            System.out.print(c[i] + " ");
        }
        System.out.println();
       int[] p1 = CPMethods.jiemi(c,k);
        for(int i = 1; i <= 8; i ++){
            System.out.print(p1[i] + " ");
        }
        System.out.println();
*/
        BruteForceCrackingMethods.CrackMethod();
    }
}
