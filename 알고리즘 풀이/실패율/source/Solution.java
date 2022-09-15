import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int[] solution(int N, int[] stages) {

        int[] arrivals = new int[N + 1];
        double[] clears = new double[N + 1];
        int[] answer = new int[N];

        for (int i = 0; i < stages.length; i++) {

            int tmp = stages[i];

            for (int j = 0; j < tmp; j++) {

                arrivals[j]++;

                if (j < tmp - 1)
                    clears[j]++;
            }
        }

        ArrayList<Double> fail = new ArrayList<Double>();

        for (int i = 0; i < N; i++) {

            double tmp;

            if(arrivals[i] == 0)
                tmp = 0;
            else
                tmp = (arrivals[i] - clears[i]) / arrivals[i];

            clears[i] = tmp;
            fail.add(tmp);
        }

        Collections.sort(fail, Collections.reverseOrder());

        for(int i = 0 ; i < N; i++){
            Double tmp = fail.get(i);

            for(int j = 0; j < N; j++){
                if(tmp == clears[j]){
                    answer[i] = j + 1;
                    clears[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
