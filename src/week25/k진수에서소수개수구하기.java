package week25;

public class k진수에서소수개수구하기 {
    class Solution {

        public int solution(int n, int k) {
            String kNum = "";
            while(n > 0) {
                String value = String.valueOf(n % k);
                kNum = value + kNum;
                n /= k;
            }
            int answer = 0;
            if(kNum.contains("0")) {
                String[] values = kNum.split("0");
                for(int i = 0; i < values.length; i++) {
                    if(values[i].equals("")) continue;
                    if(isPrime(Long.parseLong(values[i]))) answer++;
                }
            } else {
                if(isPrime(Long.parseLong(kNum))) answer++;
            }

            return answer;
        }

        public boolean isPrime(long value) {
            if(value < 2) return false;
            for(int i = 2; i <= Math.sqrt(value); i++) {
                if(value % i == 0) return false;
            }
            return true;
        }
    }
}
