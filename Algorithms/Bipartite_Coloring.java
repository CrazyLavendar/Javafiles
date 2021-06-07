
class Bipartite_Coloring
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        
        // Code here
// 
        // System.out.println(adj);
        
        
        int[] vis = new int[V];
        Arrays.fill(vis , -1);
        
        //BFS
        // Queue<Integer> q = new LinkedList<>();
        // for(int i =0 ; i < V ;i++){
            
        //     if(vis[i] == -1){
                
        //         q.add(i);
        //         vis[i] = 0;
                
        //         while(!q.isEmpty()){
                    
        //             int u = q.poll();
                    
        //             for(int v : adj.get(u)){
                        
        //                 if(vis[v] == -1){
        //                     q.add(v);
        //                     vis[v] = 1- vis[u];
        //                 }
        //                 else if(vis[v] == vis[u])
        //                     return false;
        //                 else
        //                     continue;
        //             }
                    
                    
                    
        //         }                
        //     }
            
            
            
        // }
        
        for(int i =0 ; i< V; i++){
            
            if(vis[i] == -1){
                
                if(!dfs(vis , i , adj))
                    return false;
            }
        }
        
        // for(int x : vis)
        //     System.out.print(x + " ");
        return true;
    }
    
    public boolean dfs(int[] vis, int u , ArrayList<ArrayList<Integer>>adj){
        
        if(vis[u] == -1) vis[u] = 0;
        
        for(int v : adj.get(u)){
            
            if(vis[v] == -1){
              vis[v] = 1 - vis[u]; 
              if(!dfs(vis , v , adj))
                return false;
            }
            else if(vis[v] == vis[u])
                return false;
            else
                continue;
        }
        
        
        
        return true;
    }
    
    
    
}