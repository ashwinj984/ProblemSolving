class Solution {
    
    int[][] d = {
        {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}
    };
    int m = 0;
    int n = 0;
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        dfs(board, click[0], click[1]);
            return board;
    }
    
    public void dfs(char[][] board, int r, int c){
        if(outOfBound(r,c)){
            return;
        }
        
        if(board[r][c] == 'M'){
            board[r][c] = 'X';
                return;
        }
        
        if(board[r][c] == 'E'){
            int count = checkForMines(board, r, c);
            if(count > 0){
                board[r][c] = (char)(count + '0');
                return;
            }
            
            board[r][c] = 'B';
            for(int[] arr : d){
                dfs(board, r + arr[0], c + arr[1]);
            }
        }
    }
    
    public int checkForMines(char[][] board, int r, int c){
        int count = 0;
        for(int[] arr : d){
            if(!outOfBound(r + arr[0],c + arr[1]) && board[r + arr[0]][c + arr[1]] == 'M'){
                count++;
            }
        }
        return count;
    }
    
    public boolean outOfBound(int r, int c){
        if(r < 0 || r >= m || c < 0 || c >= n){
            return true;
        }
        return false;
    }
}
