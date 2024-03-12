package week17;

public class 두원사이의정수쌍 {

    class Solution {
        public long solution(int r1, int r2) {

            long sum = 0;
            long r2x = (long) r2 * r2;
            long r1x = (long) r1 * r1;

            for(int i = r2 - 1; i >= r1; i--) {
                int height = (int) Math.sqrt(r2x - (long) i * i);
                sum += height;
            }

            for(int i = r1 - 1; i>0; i--) {
                int height1 = (int) Math.sqrt(r2x- (long) i * i);
                double height2 = Math.sqrt(r1x - (long) i * i);
                int height3 = (int) height2;


                sum += height1 - height3;
                if(height2 == (double) height3) {sum++;}

            }

            sum += r2 - r1 + 1;

            return sum * 4;
        }
    }
}
