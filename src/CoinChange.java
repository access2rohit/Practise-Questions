import java.util.*;

public class CoinChange {
    public static long makeChange(int[] coins, int money) {
        Arrays.sort(coins);
        long[] arr = new long[money+1];
        arr[0] = 1;
        for(int d=0;d<(coins.length);d++) {
            
            for(int a=coins[d];a<(money+1);a++) {
                arr[a] = arr[a] + arr[a-coins[d]];
            }
        }
        return arr[money];
    }
    
    public static long makeChangeTwo(int[] coins, int money) {
        Arrays.sort(coins);
        long[][] arr = new long[coins.length+1][money+1];
        for(int d=0;d<(coins.length+1);d++) {
            
            for(int a=0;a<(money+1);a++) {
                if(a==0) {
                    arr[d][a] = 1;
                } else if(d==0) {
                    arr[d][a] = 0;
                } else if(coins[d-1] <= a) {
                    arr[d][a] = arr[d-1][a] + arr[d][(a-coins[d-1])];
                } else {
                    arr[d][a] = arr[d-1][a];
                }
            }
        }
        return arr[coins.length][money];
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}
