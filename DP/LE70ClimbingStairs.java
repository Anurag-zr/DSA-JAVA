class LE70ClimbingStairs{

    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        
        int dp[] = new int[n+1];
        
        dp[1]=1;
        dp[2]=2;
        
        for(int i=3;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        
        return dp[n];
    }


    public static void main(String[] args){
        int n = 10; //In how many ways you can reach 10th stair
        LE70ClimbingStairs obj = new LE70ClimbingStairs();
        System.out.println(obj.climbStairs(n));
    }
}
