package week16;

public class 택배배달과수거하기 {

    class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;
            int currentIdx = n - 1;
            int deliverIdx = n - 1;
            int pickupIdx = n - 1;

            while(deliverIdx >= 0 && pickupIdx >= 0) {

                int dist = Math.max(deliverIdx, pickupIdx);

                answer += 2 * (dist);

                int tmpDeliver = deliverIdx;
                int currentCap = cap;
                while(currentCap > 0 && tmpDeliver >= 0) {
                    if(deliveries[tmpDeliver] > 0) {
                        if(deliveries[tmpDeliver] > currentCap) {
                            deliveries[tmpDeliver] -= currentCap;
                            break;
                        } else if(deliveries[tmpDeliver] == currentCap) {
                            deliveries[tmpDeliver] = 0;
                            break;
                        } else {
                            currentCap -= deliveries[tmpDeliver];
                            deliveries[tmpDeliver--] = 0;
                        }
                    } else {
                        tmpDeliver--;
                    }
                }

                deliverIdx = tmpDeliver;

                int tmpPickup = pickupIdx;
                currentCap = 0;

                while(currentCap < cap  && tmpPickup >= 0) {
                    int canHandle = cap - currentCap;
                    if(pickups[tmpPickup] > 0) {
                        if(pickups[tmpPickup] > canHandle) {
                            pickups[tmpPickup] -= canHandle;
                            break;
                        } else if(pickups[tmpPickup] == canHandle) {
                            pickups[tmpPickup] = 0;
                            break;
                        } else {
                            currentCap += pickups[tmpPickup];
                            pickups[tmpPickup--] = 0;
                        }
                    } else {
                        tmpPickup--;
                    }
                }

                pickupIdx = tmpPickup;


            }

            return answer;
        }
    }
}
