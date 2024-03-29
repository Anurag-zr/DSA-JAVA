import java.util.*;

class LM198HouseRobber{

        //memoization solution
    public static int helper(int ind,int[] nums,int[] dp){
        if(ind==0) return nums[ind];
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        
        //not pick 
        int notPick= 0+helper(ind-1,nums,dp);
        //pick;
        
        int pick = nums[ind] + helper(ind-2,nums,dp);
        
        return dp[ind]=Math.max(notPick,pick);
    }
    
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(n-1,nums,dp);
    }
    
    
    // //tabulation solution
    
    // public static int rob(int[] nums){
    //     int n = nums.length;
    //     int[] dp = new int[n];
        
    //     dp[0] = nums[0];
        
    //     for(int i=1;i<n;i++){
    //         //not pick
            
    //         int notPick =0+dp[i-1];
    //         //pick
    //         int pick= nums[i];
    //         if(i-2>=0)
    //             pick += dp[i-2];
            
            
    //         dp[i] = Math.max(pick,notPick);
    //     }
        
        
    //     return dp[n-1];
    // }

    public static void main(String[] args){
        /* 
Input: nums = [1,2,3,1]
Output: 4
        */

        int[] nums ={1,2,3,1};
        System.out.println(rob(nums));

    }
}