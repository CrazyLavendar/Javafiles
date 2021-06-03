
class KruskalSpanningTree
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    
    class Edge{
        int s,d,w;
        public Edge(int source , int dest , int weight){
            this.s = source;
            this.d = dest;
            this.w = weight;
        }
        
    }
    
     int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        Queue<Edge> q = new PriorityQueue<>((Edge a , Edge b)-> a.w - b.w);
        for(int i =0 ; i < adj.size() ; i++){ 
            // i is source
            
            for(int j =0 ; j < adj.get(i).size() ;j++){
                // j is edges of i nodes
                q.add(new Edge(i , adj.get(i).get(j).get(0) , adj.get(i).get(j).get(1)));
                
            }
        }
        // System.out.println(q.size());
        
        List<Set<Integer>> list = new ArrayList<>();
        
        int weight = 0;
        
        while(!q.isEmpty()){
            
            int currWeight = q.peek().w;
            int source = q.peek().s;
            int dest = q.poll().d;
            
            if(unionFind (list, source , dest)){
                // System.out.println(source + " " +dest);
                weight += currWeight;
            }
            
        }
        return weight;
    }
    
    public boolean unionFind(List<Set<Integer>> list , int s , int d){
        
        int set_s = -1 , set_d = -1;
        for(int i =0 ; i< list.size() ; i++){
            
            if(list.get(i).contains(s))
                set_s = i;
            if(list.get(i).contains(d))
                set_d = i;
        }
        
        if(set_s == -1 && set_d == -1){
            Set<Integer> set = new HashSet<>();
            set.add(s);
            set.add(d);
            list.add(set);
        }else if(set_d == -1){
            list.get(set_s).add(d);
        }else if(set_s == -1){
            list.get(set_d).add(s);
        }else if(set_s == set_d){ //contains cycle
            return false;
        }else{
            int min = Math.min(set_s , set_d);
            int max = Math.max(set_s , set_d);
            
            Set<Integer> temp = list.get(max);
            list.remove(max);
            
            Set<Integer> union = list.get(min);
            list.remove(min);
            
            for(int x : temp)
                union.add(x);
            
            list.add(union);
            
        }
    
    return true;        
    }
}
