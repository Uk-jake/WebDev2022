public class Solution {

    public int solution1(int[][] sizes) {

        int maxWidth = 0, maxHeight = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = tmp;
            }
            if (maxWidth < sizes[i][0]) {
                maxWidth = sizes[i][0];
            }
            if (maxHeight < sizes[i][1]) {
                maxHeight = sizes[i][1];
            }
        }
        return maxHeight * maxWidth;
    }

    public int solution2(int[][] sizes){

        int maxWidth = 0, maxHeight = 0;

        for(int[] size:sizes){
            int maxTmp = Math.max(size[0],size[1]);
            int minTmp = Math.min(size[0],size[1]);

            maxWidth = Math.max(maxWidth,maxTmp);
            maxHeight = Math.max(maxHeight,minTmp);
        }
        return maxHeight * maxWidth;
    }
}
