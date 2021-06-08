public class DijikstraPriorityQueue {
       
    class Node{
        int u , weight ;
        Node(int u , int weight){
            this.u = u ;
            this.weight = weight;
        }
    }
     
    
    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        
        int[] dis = new int[V];
        for(int i =0 ; i<V ; i++)
            dis[i] = Integer.MAX_VALUE;
        
        Queue<Node> q = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        boolean[] vis = new boolean[V];
        
        dis[S] = 0;
        q.add(new Node(S , 0));
        
        // System.out.println(adj);
        
        while(!q.isEmpty()){
            
            Node s = q.poll(); // source
            vis[s.u] = true;
            
            for(ArrayList<Integer> des : adj.get(s.u)){
                int v = des.get(0) , v_weight = des.get(1);
                if(!vis[v]){
                    if(dis[v]  > dis[s.u] + v_weight){
                        dis[v]  = dis[s.u] + v_weight;
                        q.add(new Node( v, dis[v]));
                    }
                }
            }
        }
        
        
        return dis;
    }
    

}

    

