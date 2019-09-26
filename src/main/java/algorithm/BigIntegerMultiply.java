package algorithm;

/**
 * @Author: weipeng
 * @Date: 2019/5/31  14:58
 * @Description:
 **/
public class BigIntegerMultiply {

    //没有使用分治法，时间复杂度为O(n)
    public static String multiply(String bigNumberA, String bigNumberB) {

        //1.把两个大整数用数组逆序存储，数组长度等于两整数长度之和
        int lengthA = bigNumberA.length();
        int lengthB = bigNumberB.length();

        int[] arrayA = new int[lengthA];
        for(int i=0; i< lengthA; i++){
            arrayA[i] = bigNumberA.charAt(lengthA-1-i) - '0';
        }

        int[] arrayB = new int[lengthB];
        for(int i=0; i< lengthB; i++){
            arrayB[i] = bigNumberB.charAt(lengthB-1-i) - '0';
        }

        //2.构建result数组，数组长度等于两整数长度之和
        int[] result = new int[lengthA+lengthB];

        //3.嵌套循环，整数B的每一位依次和整数A的所有数位相乘，并把结果累加
        for(int i=0;i<lengthB;i++) {
            for(int j=0;j<lengthA;j++) {
                //整数B的某一位和整数A的某一位相乘
                result[i+j] += arrayB[i]*arrayA[j];
                //如果result某一位大于10，则进位，进位数量是该位除以10的商
                if(result[i+j] >= 10){
                    result[i+j+1] += result[i+j]/10;
                    result[i+j] = result[i+j]%10;
                }
            }
        }

        //4.把result数组再次逆序并转成String
        StringBuilder sb = new StringBuilder();
        //是否找到大整数的最高有效位
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if(!findFirst){
                if(result[i] == 0){
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }


    public static void test(String[] args) {
        String x = "3338429042340042304302404";
        String y = "12303231";
        System.out.println(multiply(x, y));
    }


}
