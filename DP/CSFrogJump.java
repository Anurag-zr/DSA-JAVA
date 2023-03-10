import java.util.*;
class CSFrogJump{

        public static int frogJump(int n, int heights[]) {

        // Write your code here..
        if(n==1) return 0;
        if(n==2) return Math.abs(heights[1]-heights[0]);

        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        dp[0]=0;
        dp[1]= Math.abs(heights[1]-heights[0]);

        for(int i=2;i<n;i++){
            dp[i] = Math.min(dp[i-1] + Math.abs(heights[i]-heights[i-1]), dp[i-2]+Math.abs(heights[i]-heights[i-2]));
        }


        return dp[n-1];
    }

    public static void main(String[] args){
        int n =4;
        int dp[]={10,20,30,10};

        System.out.println(frogJump(n,dp));

    }
}