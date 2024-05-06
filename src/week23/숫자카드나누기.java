package week23;

public class 숫자카드나누기 {

    class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int answer = 0;

            int gcdA = arrayA[0];
            int gcdB = arrayB[0];

            for(int i = 1; i < arrayA.length; i++) {
                gcdA = gcd(arrayA[i], gcdA);
                gcdB = gcd(arrayB[i], gcdB);
            }

            for(int b : arrayB) {
                if(b %gcdA == 0) {
                    gcdA = 0;
                    break;
                }
            }


            for(int a : arrayA) {
                if(a %gcdB == 0) {
                    gcdB = 0;
                    break;
                }
            }

            return Math.max(gcdA, gcdB);
        }

        private int gcd(int a, int b) {
            if(b == 0) return a;
            else {
                return gcd(b, a % b);
            }
        }
    }
}
