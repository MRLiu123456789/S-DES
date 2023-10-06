package BaseDataTools;

//用于生成密钥的基本数据。
public class BasePasswordTools {
    private static int[] P10 = {3,5,2,7,4,10,1,9,8,6};
    private static int[] P8 = {6,3,7,4,8,5,10,9};

    private static int[] LeftShift1 = {2,3,4,5,1};

    private static int[] LeftShift2 = {3,4,5,1,2};

    public static int[] getP10() {
        return P10;
    }

    public static int[] getP8() {
        return P8;
    }

    public static int[] getLeftShift1() {
        return LeftShift1;
    }

    public static int[] getLeftShift2() {
        return LeftShift2;
    }
}
