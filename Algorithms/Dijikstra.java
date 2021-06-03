

class Dijikstra
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    

    
     int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
 
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];
        
        for(int i =0 ; i< V; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[S] = 0;
        
        for(int count =0 ; count < V-1 ; count ++){ // no of edges less than vertice
            
            int u = minKey(dist ,sptSet );
            sptSet[u] = true;
            
            ArrayList<ArrayList<Integer>> node = adj.get(u);
            
            for(int i = 0 ;i< node.size(); i++){
                int v = node.get(i).get(0) , w = node.get(i).get(1);
                if(!sptSet[v] && dist[u] != Integer.MAX_VALUE &&   dist[u] +  w < dist[v]){
                    // parent[v] = u;
                    dist[v] = dist[u] +  w;
                }
            }
        }
        
        // System.out.println(adj);
        
        
        return dist;
        
    }
    
        int minKey(int[] key , boolean[] mstSet){
        
        int min = Integer.MAX_VALUE , minIndex = -1;
        
        for(int i= 0 ; i < key.length ; i++){
            
            if(mstSet[i] == false && key[i] <= min){
                min = key[i];
                minIndex = i;            }
            
        }
        return minIndex;
        
    }
    
     
}

