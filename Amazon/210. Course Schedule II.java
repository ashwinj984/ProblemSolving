class Solution {
    Stack<Integer> st = new Stack<>();
    public int[] findOrder(int n, int[][] arr) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] p : arr){
            graph[p[1]].add(p[0]);
        }        
        int[] result = new int[n];
        int[] visited = new int[n];
        for(int i = 0; i < n; i++){
            boolean checkCycle = dfs(graph, visited, i);
            if(checkCycle){
                return new int[0];
            }
        }
        
        for(int i = 0; i < n; i++){
            result[i] = st.pop();
        }
        return result;
    }
    
    public boolean dfs(ArrayList<Integer>[] graph, int[] visited, int i){
        if(visited[i] == 2){
            return false;
        }
        
        visited[i] = 1;
        for(var g : graph[i]){
            if(visited[g] == 1){
                return true;
            }else if(visited[g] == 0){
                if(dfs(graph, visited, g)){
                    return true;
                }
            }
        }
        visited[i] = 2;
        st.push(i);
        return false;
    }
}
