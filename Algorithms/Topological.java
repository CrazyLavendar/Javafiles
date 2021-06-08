

class Topological
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] vis = new int[V];
        int[] res = new int[V];
        
        
        // DFS Algorithm
        // Stack<Integer> s = new Stack<>();
        // for(int i =0 ; i< V ;i++){
        //     if(vis[i] == 0){
        //         dfsTopo(adj , i , vis , s);
        //     }
        // }
        // int i =0;
        // while(!s.isEmpty())
        //     res[i++] = s.pop();
        
        int[] inDeg = new int[V];
        Queue<Integer> q = new LinkedList<>();
        
        for(ArrayList<Integer> dest : adj){
            for(int v : dest){
                inDeg[v]++;                
            }
        }
        for(int i =0 ; i< V ; i++){
            if(inDeg[i] ==0)
                q.add(i);
        }
        int index = 0;
        while(!q.isEmpty()){
            
            int u = q.poll();
            res[index++] = u;
            
            for(int v : adj.get(u))
                if(inDeg[v] > 0){
                    inDeg[v]--;
                    if(inDeg[v] == 0)
                         q.add(v);
                }
        }
            
        // for(int x : res)
        //     System.out.print(x + " ");
        // System.out.println("");
        
        return res;
    }
    
    static void dfsTopo(ArrayList<ArrayList<Integer>> adj , int u ,int[] vis , Stack<Integer> s ){
        
        // if(vis[u] == 1)
        //     return;
        
        vis[u] = 1;
        
        for(int v : adj.get(u)){
            
            if(vis[v] == 0)
                dfsTopo(adj , v , vis, s);
            
        }
        
        s.push(u);
    }
}
