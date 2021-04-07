class Knapsack 
{ 
    int[] wt , val;
    int[][] mem ;
    int[][] dp;
    // Returns the maximum value that can be put in a knapsack of capacity W 
     int knapSack(int W, int wt[], int val[], int n) 
    { 
        this.wt = wt;
        this.val = val;
        
        // return solveRecursion(W , n );
       
    //   mem = new int[W+1][n+1];
    //   for(int[] row : mem)
    //   Arrays.fill(row , -1);
    //   return solveMemRecursion(W , n);
    
    dp = new int[n+1][W+1];
    return solveTabulationDP(W , n);
    
         // your code here 
    } 
    
    
    // Naive recursion
     int solveRecursion(int W , int n ){
        if(W==0 || n == 0)
            return 0;
        else if(wt[n-1] > W)
            return solveRecursion(W , n-1);
        else
            return Math.max(solveRecursion(W , n-1) , 
            val[n-1] + solveRecursion(W - wt[n-1] ,n-1)
            );
    }
    
     int solveMemRecursion(int W , int n ){
            int result;
        if(W==0 || n == 0)
            return 0;
        else if(mem[W][n] != -1)
         return mem[W][n];
        else if(wt[n-1] > W)
            result =  solveMemRecursion(W , n-1);
        else
            result =  Math.max(solveMemRecursion(W , n-1) , 
            val[n-1] + solveMemRecursion(W - wt[n-1] ,n-1)
            );
        return mem[W][n] = result;
    }
    
    int solveTabulationDP(int W ,int  n){
        for(int i = 0 ; i<= n ; i++){
            for(int j = 0 ; j<= W ; j++){
                if(i==0 || j==0)
                    dp[i][j] =0;
                else if(wt[i-1] > j)
                    dp[i][j] = dp [i-1][j];
                else
                    {
                        dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);
                    }
            }
        }
        return dp[n][W];
    }
}