package week16;

public class 표현가능한이진트리 {

    class Solution {


        private boolean dfs(String binaryTree) {
            if (binaryTree.length() <= 1) {
                return true;
            }

            String leftTree = binaryTree.substring(0, binaryTree.length() / 2);
            String rightTree = binaryTree.substring(binaryTree.length() / 2 + 1);

            char root = binaryTree.charAt(binaryTree.length() / 2);
            char left = leftTree.charAt(leftTree.length() / 2);
            char right = rightTree.charAt(rightTree.length() / 2);

            if (root == '0' && (left == '1' || right == '1') )
                return false;
            else
                return dfs(leftTree) && dfs(rightTree);

        }
        public int[] solution(long[] numbers) {

            int[] answer = new int[numbers.length];

            for(int i = 0 ; i<numbers.length; i ++) {
                String binary = Long.toBinaryString(numbers[i]);
                int j = 0;
                while((int)Math.pow(2, j) - 1 < binary.length()) {
                    j++;
                }

                while(binary.length() < (int)Math.pow(2, j) - 1) {
                    binary = "0" + binary;
                }

                if(dfs(binary)) answer[i] = 1;
                else answer[i] = 0;




            }

            return answer;
        }
    }
}
