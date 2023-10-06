package BaseDataTools;


//进行加密和解密的基本数据。
public class BaseCPTools {
    private static int[] IP = {2,6,3,1,4,8,5,7};

    private static int[] IP_1 = {4,1,3,5,7,2,8,6};

    private static int[] EPBox = {4,1,2,3,2,3,4,1};

    private static int[][] SBox1 = {{1,0,3,2},{3,2,1,0},{0,2,1,3},{2,1,0,3}};

    private static int[][] SBox2 = {{0,1,2,3},{2,3,1,0},{3,0,1,2},{2,1,0,3}};

    private static int[] SPBox = {2,4,3,1};

    public static int[] getIP() {
        return IP;
    }

    public static int[] getIp1() {
        return IP_1;
    }

    public static int[] getEPBox() {
        return EPBox;
    }

    public static int[][] getSBox1() {
        return SBox1;
    }

    public static int[][] getSBox2() {
        return SBox2;
    }

    public static int[] getSPBox() {
        return SPBox;
    }
}
