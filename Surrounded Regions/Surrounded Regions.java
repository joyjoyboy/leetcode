public class Solution {
    
    private class Pair{
        int x;
        int y;
        Pair(int x1, int y1){
            x = x1;
            y = y1;
        }
    }
    
    public void solve(char[][] board) {
        Stack<Pair> workingList = new Stack<Pair>();
        
        if(board.length == 0 || board[0].length == 0)       return;
        
        for(int i = 0; i < board.length; ++i){
            if(board[i][0] == 'O')                          workingList.push(new Pair(i, 0));
            if(board[i][board[0].length - 1] == 'O')        workingList.push(new Pair(i, board[0].length - 1));
        }
        for(int j = 0; j < board[0].length; ++j){
            if(board[0][j] == 'O')                          workingList.push(new Pair(0, j));
            if(board[board.length - 1][j] == 'O')           workingList.push(new Pair(board.length - 1, j));
        }
        
        while(!workingList.isEmpty()){
            Pair curr = workingList.pop();
            board[curr.x][curr.y] = 'A';
            if(curr.x < board.length - 1 && board[curr.x + 1][curr.y] == 'O'){
                workingList.push(new Pair(curr.x + 1, curr.y));
            }
            if(curr.x > 0 && board[curr.x - 1][curr.y] == 'O'){
                workingList.push(new Pair(curr.x - 1, curr.y));
            }
            if(curr.y < board[0].length - 1 && board[curr.x][curr.y + 1] == 'O'){
                workingList.push(new Pair(curr.x, curr.y + 1));
            }
            if(curr.y > 0 && board[curr.x][curr.y - 1] == 'O'){
                workingList.push(new Pair(curr.x, curr.y - 1));
            }
        }
        
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == 'O')          board[i][j] = 'X';
                else if(board[i][j] == 'A')     board[i][j] = 'O';
            }
        }
        
        return;
    }
}
