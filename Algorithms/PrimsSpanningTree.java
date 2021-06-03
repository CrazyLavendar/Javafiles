

// User function Template for Java

class PrimsSpanningTree
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    

    
     int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // System.out.println(adj);
        int[] parent = new int[V];
        
        boolean[] mstSet = new boolean[V];
        
        int[] key = new int[V];
        
        for(int i =0 ; i< V; i++){
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        
        key[0] = 0;
        parent[0] = -1;
        
        for(int count =0 ; count < V-1 ; count ++){ // no of edges less than vertice
            
            int u = minKey(key , mstSet);
            mstSet[u] = true;
            ArrayList<ArrayList<Integer>> node = adj.get(u);
            for(int i = 0 ;i< node.size(); i++){
                int v = node.get(i).get(0) , w = node.get(i).get(1);
                if(mstSet[v] == false && w < key[v]){
                    parent[v] = u;
                    key[v] = w;
                }
            }
        }
        
        int res =0 ;
        for(int i = 0; i< V ; i++){
            res+= key[i];
        }
        
        return res;
    }
    
    int minKey(int[] key , boolean[] mstSet){
        
        int min = Integer.MAX_VALUE , minIndex = -1;
        
        for(int i= 0 ; i < key.length ; i++){
            
            if(mstSet[i] == false && key[i] < min){
                min = key[i];
                minIndex = i;            }
            
        }
        return minIndex;
        
    }
   
}


