class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    dfs(visited, grid, i, j);
                    count++;
                }
                
            }
        }
        return count;
    }
    
    public void dfs(boolean[][] visited, char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 | j >= grid[0].length || visited[i][j] == true || grid[i][j] == '0'){
            return;
        }
        
        visited[i][j] = true;
        for(int[] d : direc){
            int newi = i + d[0];
            int newj = j + d[1];
            dfs(visited, grid, newi, newj);
        }
    }
    
    int[][] direc = {
        {-1,0},{0,1},{1,0},{0,-1}
    };
}
