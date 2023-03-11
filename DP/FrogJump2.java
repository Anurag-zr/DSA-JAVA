import java.util.*;

class FrogJump2{

    public static int frogJump(int n,int k,int heights[]){
        if(n==1) return 0;
        if(n==2) return Math.abs(heights[1]-heights[0]);

        int dp[] = new int[n];

        dp[0]=0;
        dp[1]= Math.abs(heights[0]-heights[1]);

        for(int i=2;i<n;i++){
            int mini=Integer.MAX_VALUE;
            for(int jump=1;jump<=k;jump++){
                int cost=(int)1e9;
                if(i-jump>=0)
                    cost = dp[i-jump]+Math.abs(heights[i]-heights[i-jump]);
                
                mini = Math.min(mini,cost);
            }

            dp[i] = mini;
        }


        return dp[n-1];

    }

    public static void main(String[] args){
        int n=10;
        int k=4;
        int heights[] = {40,10,20,70,80,10,20,70,80,60};
        System.out.println(frogJump(n, k, heights));


    }
}