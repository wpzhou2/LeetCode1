package algorithm;

/**
 * @Author: weipeng
 * @Date: 2019/5/31  11:13
 * @Description:
 **/
public class Hanoi {
    private int n;
    private String a,b,c;

    public void move(int n , String a ,String b ,String c) {
        if(n == 1) {
            System.out.println(a + ">>"+ c);
        }
        else {
            this.move(n-1, a, c, b);//将n-1个盘子从a借助c搬到b
            System.out.println(a + ">>"+c);
            this.move(n-1, b, a, c);//将n-1个盘子从b借助a搬到c
        }
    }
}
