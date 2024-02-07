package week13;

public class N_Plus_1카드게임 {

    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int answer = 0;

        int[] hands = new int[n];
        int[] keepCards = new int[n];
        int nextHandsIdx = n / 3;
        for(int i = 0; i<n / 3; i++) {
            hands[i] = cards[i];
        }

        int nextCardIdx = n / 3;
        int keepCardsIdx = 0;

        while(true) {
            answer++;
            System.out.println(nextCardIdx);
            if(nextCardIdx == n ) break;
            for(int i = 0; i < 2; i++){
                keepCards[keepCardsIdx++] = cards[nextCardIdx++];
            }

            boolean flag = false;

            for(int i = 0; i<nextHandsIdx - 1 && !flag; i++) {
                if(hands[i] == 0) continue;
                for(int j = i + 1; j < nextHandsIdx; j++) {
                    if(hands[j] == 0) continue;
                    if(hands[i] + hands[j] == n + 1) {
                        hands[i] = 0;
                        hands[j] = 0;
                        flag = true;
                        break;
                    }
                }
            }

            if(flag) continue;

            for(int i = 0; i< nextHandsIdx && !flag; i++) {
                if(hands[i] == 0) continue;
                for(int j = 0; j < keepCardsIdx; j++) {
                    if(keepCards[j] == 0) continue;
                    if(hands[i] + keepCards[j] == n + 1) {
                        if(coin > 0) {
                            coin--;
                            hands[nextHandsIdx++] = keepCards[j];
                            hands[i] = 0;
                            keepCards[j] = 0;
                            flag = true;
                            break;
                        }

                    }
                }
            }

            if(flag) continue;

            for(int i = 0; i< keepCardsIdx - 1 && !flag; i++) {
                if(keepCards[i] == 0) continue;
                for(int j = i + 1; j < keepCardsIdx; j++) {
                    if(keepCards[j] == 0) continue;
                    if(keepCards[i] + keepCards[j] == n + 1) {
                        if(coin >= 2) {
                            coin -= 2;
                            keepCards[i] = 0;
                            keepCards[j] = 0;
                            flag = true;
                            break;
                        }

                    }
                }
            }

            if(!flag) break;
        }

        return answer;
    }
}

