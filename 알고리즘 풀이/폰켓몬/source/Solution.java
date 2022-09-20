import java.util.ArrayList;

public class Solution {
    public int solution(int[] nums) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i : nums) {
            if (!(list.contains(i)))
                list.add(i);
        }

        if (list.size() < nums.length / 2)
            return list.size();

        return nums.length / 2;

    }
}
