// LESS EFFICIENT CODE
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int val = prerequisites[i][0];
            indegree[val]++;
        }
        
        Queue<Integer> q =  new ArrayDeque<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int canComplete = q.size();
        while(q.size() > 0){
            int val = q.remove();
            for(int i = 0; i < prerequisites.length; i++){
                int src = prerequisites[i][0];
                int dest = prerequisites[i][1];
                if(dest == val){
                    indegree[src]--;
                    if(indegree[src] == 0){
                        canComplete++;
                        q.add(src);
                    }
                }
            }
        }
        return canComplete == numCourses;
    }
}

// MORE EFFICIENT METHOD
class Solution {
    public boolean canFinish(int n, int[][] arr) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int[] p : arr){
            indegree[p[0]]++;
            graph[p[1]].add(p[0]);
        }
        
        for(int i = 0; i < n; i++){
             if(indegree[i] == 0) {
                 q.add(i);
             }
        }
        
        int count = 0;
        while(q.size() > 0){
            int val = q.remove();
            for(var g : graph[val]){
                indegree[g]--;
                if(indegree[g] == 0){
                    q.add(g);
                }
            }
            count++;
        }
        return count == n;
    }
}
