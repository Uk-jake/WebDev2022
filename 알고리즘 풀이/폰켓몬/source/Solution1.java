import java.util.HashSet;

public class Solution1 {

    public int solution1(int[] nums){

        HashSet<Integer> hashSet = new HashSet<Integer>();

        for(int i : nums)
            hashSet.add(i);

        return hashSet.size() < nums.length / 2 ? hashSet.size() : nums.length / 2;

    }
}
