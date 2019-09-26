package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  20:54
 * @Description:
 **/
public class LC_134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;//起点
        int total = 0;//记录油量存量
        int sum = 0;//记录从某点开始到现在某位置的油量存量

        for(int i=0; i<gas.length; i++){
            int remainder = gas[i] - cost[i]; //每一站的积蓄:加油量-耗油量
            total += remainder;
            sum += remainder;
            if(sum < 0){
                // 试试下一个起始点
                start = i+1;
                sum = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
