import java.util.ArrayList;
public class Solution {
    public int[] solution(int[] answers) {
        int user[][] = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] counts = new int[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (user[i][j % user[i].length] == answers[j]) {
                    counts[i]++;
                }
            }
        }

        int maxScore = Math.max(counts[0], Math.max(counts[1], counts[2]));

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i<counts.length;i++){
            if(maxScore == counts[i])
                answer.add(i+1);
        }

        int[] result = new int[answer.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
