import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Solution1 {

    class Fail {
        int stage;
        double fail;

        Fail(int stage, double fail) {
            this.stage = stage;
            this.fail = fail;
        }
    }

    Comparator<Fail> comp = new Comparator<Fail>() {

        public int compare(Fail a, Fail b) {
            if (a.fail < b.fail)
                return 1;
            else if (a.fail > b.fail)
                return -1;
            else {
                if (a.stage > b.stage)
                    return 1;
                else if (a.stage < b.stage)
                    return -1;
                else
                    return 0;
            }
        }
    };

    public int[] solution1(int N, int[] stages) {

        int[] answer = new int[N];

        int[] users = new int[N + 1];

        for (int s : stages) {
            users[s - 1]++;
        }

        ArrayList<Fail> FailLates = new ArrayList<Fail>();

        int totalUser = stages.length;

        for (int i = 0; i < N; i++) {

            double fail;

            if (totalUser <= 0) {
                fail = 0;
            } else {
                fail = users[i] / (double) totalUser;
                totalUser = totalUser - users[i];
            }

            Fail tmp = new Fail(i + 1, fail);

            FailLates.add(tmp);
        }

        for (Fail tmp : FailLates) {
            System.out.println(tmp.stage + " : " + tmp.fail);
        }

        Collections.sort(FailLates, comp);

        for (int i = 0; i < FailLates.size(); i++) {
            answer[i] = FailLates.get(i).stage;
        }

        return answer;
    }
}
