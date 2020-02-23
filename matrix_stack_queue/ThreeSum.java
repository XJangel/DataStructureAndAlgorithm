package matrix_stack_queue;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.dialect.function.StandardAnsiSqlAggregationFunctions.SumFunction;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return null;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int L =0, R = 0;
        for(int i = 0; i < nums.length-2; i++) {
            L = i+1;
            R = nums.length - 1;
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            while(L < R) {
                if(nums[i] + nums[L] + nums[R] == 0) {
                    list.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L < R && nums[L+1] == nums[L]) L++;
                    while(L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }else if (nums[i] + nums[L] + nums[R] < 0) {
                    L++;
                }else {
                    R--;
                }
            }
        }
        return list;
    }

}
