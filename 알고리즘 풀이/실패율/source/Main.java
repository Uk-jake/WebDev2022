
public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int N = 4;
        int[] stages = {1,2,3,2,1};

        int[] result;

        result = solution.solution(N,stages);

        for(int i = 0; i< result.length; i++){
            System.out.println(result[i]);
        }
    }
}