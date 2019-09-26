package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weipeng
 * @Date: 2019/5/26  22:15
 * @Description:
 **/
public class LC_401_BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<String>();
        for(int h = 0;h<12;h++)
            for(int m = 0;m<60;m++)
            {
                if(Integer.bitCount(h)+Integer.bitCount(m)==num)
                    times.add(String.format("%d:%02d",h,m));
            }
        return times;
    }
}
