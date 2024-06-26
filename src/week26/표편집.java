package week26;

import java.util.Stack;

public class 표편집 {

    class Solution {

        static class Node {
            Node prev = null;
            Node next = null;
            boolean isDeleted;


            public Node delete() {
                Node prev = this.prev;
                Node next = this.next;

                this.isDeleted = true;
                if(prev == null) {
                    next.prev = null;
                    return next;
                } else if(next == null) {
                    prev.next = null;
                    return prev;
                } else {
                    prev.next = next;
                    next.prev = prev;
                    return next;
                }

            }

            public void restore() {
                Node prev = this.prev;
                Node next = this.next;
                this.isDeleted = false;
                if(prev != null) prev.next = this;
                if(next != null) next.prev = this;
            }

            public Node up(int amount) {
                Node node = this;
                for(int i = 0; i < amount; i++) {
                    node = node.prev;
                }
                return node;
            }

            public Node down(int amount) {
                Node node = this;
                for(int i = 0; i < amount; i++) {
                    node = node.next;
                }
                return node;
            }
        }

        Stack<Node> stack = new Stack<>();

        public String solution(int n, int k, String[] cmd) {
            Node[] nodes = new Node[n];
            for(int i =0; i < n; i++) {
                Node node = new Node();
                nodes[i] = node;
                if(i == 0) {
                    continue;
                }
                nodes[i].prev = nodes[i-1];
                nodes[i-1].next = nodes[i];
            }

            Node cur = nodes[k];
            for(String command : cmd) {
                if(command.startsWith("C") || command.startsWith("Z")) {
                    if(command.equals("C")) {
                        stack.push(cur);
                        cur = cur.delete();
                    } else {
                        Node node = stack.pop();
                        node.restore();
                    }
                } else {
                    String[] commands = command.split(" ");
                    int amount = Integer.valueOf(commands[1]);
                    if(commands[0].equals("U")) {
                        cur = cur.up(amount);
                    } else {
                        cur = cur.down(amount);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++) {
                if(nodes[i].isDeleted) sb.append("X");
                else sb.append("O");
            }
            return sb.toString();
        }
    }
}
