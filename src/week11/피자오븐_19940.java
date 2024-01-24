package week11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 피자오븐_19940 {

    static class Button {

        int addH;
        int addT;
        int minT;
        int addO;
        int minO;

        public Button(int addH, int addT, int minT, int addO, int minO) {
            this.addH = addH;
            this.addT = addT;
            this.minT = minT;
            this.addO = addO;
            this.minO = minO;
        }
    }

    static List<Button> buttons;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        buttons = new ArrayList<>(T);
        for (int i = 0; i < T; i++) {
            int purposeTime = scanner.nextInt();
            int addH = 0;
            int addT = 0;
            int minT = 0;
            int addO = 0;
            int minO = 0;

            addH += purposeTime/60;
            purposeTime %= 60;
            if (purposeTime <= 35) {
                if (purposeTime % 10 > 5) {
                    addT += purposeTime / 10 + 1;
                    minO += 10 - purposeTime % 10;
                } else {
                    addT += purposeTime / 10;
                    addO += purposeTime % 10;
                }
            } else {
                addH++;
                if (purposeTime % 10 >= 5) {
                    minT += 6 - (purposeTime / 10 + 1);
                    minO += 10 - purposeTime % 10;
                } else {
                    minT += 6 - purposeTime / 10;
                    addO += purposeTime % 10;
                }
            }


            buttons.add(new Button(addH, addT, minT, addO, minO));
        }

        StringBuilder sb = new StringBuilder();
        for (Button button : buttons) {
            sb.append(button.addH).append(" ")
                    .append(button.addT).append(" ")
                    .append(button.minT).append(" ")
                    .append(button.addO).append(" ")
                    .append(button.minO).append("\n");
        }

        System.out.println(sb);



    }

}

