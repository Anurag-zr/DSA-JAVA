import java.util.*;

class LH403FrogJump{


// method 1

    //     public static boolean canCross(int[] stones) {
        
    //     HashMap<Integer,HashSet<Integer>> map = new HashMap<Integer,HashSet<Integer>>();
        
    //     for(int stone : stones){
    //         map.put(stone,new HashSet<Integer>());
    //     }
    //     map.get(0).add(1); 
        
    //     for(int i=0;i<stones.length;i++){
    //         int stone = stones[i];
            
    //         for(int step : map.get(stone)){
    //             int reach = stone + step;
                
    //             if(reach==stones[stones.length-1]) return true;
                
    //             if(map.get(reach)!=null){
    //                 HashSet<Integer> set = map.get(reach);
    //                 set.add(step);
    //                 if(step-1>0) set.add(step-1);
    //                 set.add(step+1);
    //             }
    //         }
    //     }
        
    //     return  false;
    // }


    

 // method 2 dynamic programming

    public static boolean canCross(int stones[]){
        int n = stones.length;
        // System.out.println(n);

        //default value false
        boolean dp[][] = new boolean[n][n+1];
        // System.out.println(dp[0][0]);

        dp[0][1]=true;

        boolean answer = false;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int dist = stones[i]- stones[j];

                if(dist<=0 || dist>n || !dp[j][dist]) continue;

                if(i==n-1) answer=true;
                dp[i][dist]=true;
                if(dist-1>0) dp[i][dist-1] = true;
                if(dist+1<=n) dp[i][dist+1] =true;

            }
        }

        for(boolean[] stone : dp){
            for(boolean ele: stone) System.out.print(ele + " ");
            System.out.println();
        }

        return answer;
    }   


    public static void main(String[] args){

/* 
Input: stones = [0,1,3,5,6,8,12,17]
Output: true
*/

        int stones[] = {0,1,3,5,6,8,12,17};

        System.out.println(canCross(stones));
    }
}