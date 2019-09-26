package LeetCode;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  20:54
 * @Description:
 **/
public class LC_134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;//���
        int total = 0;//��¼��������
        int sum = 0;//��¼��ĳ�㿪ʼ������ĳλ�õ���������

        for(int i=0; i<gas.length; i++){
            int remainder = gas[i] - cost[i]; //ÿһվ�Ļ���:������-������
            total += remainder;
            sum += remainder;
            if(sum < 0){
                // ������һ����ʼ��
                start = i+1;
                sum = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
