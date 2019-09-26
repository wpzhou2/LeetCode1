package LeetCode1;

/**
 * @Author: weipeng
 * @Date: 2019/6/15  22:23
 * @Description:
 **/
public class LC_860_Lemonade {
    //贪心算法入门级
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int bill: bills){
            if(bill == 5){
                five++;
            }
            else if(bill == 10){
                if(five==0) return false;
                five--;
                ten++;
            }
            else{
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }
                else if(five >= 3){
                    five -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
