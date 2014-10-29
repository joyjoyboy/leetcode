public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<Integer>();
        }
        
        List<Integer> ret = new ArrayList<Integer>();
        
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        // 0: right
        // 1: down
        // 2: left
        // 3: up
        int direction = 0;
        int counter = 0;
        int x = 0;
        int y = 0;
        visited[x][y] = true;
        ret.add(matrix[x][y]);
        while(counter < matrix.length * matrix[0].length - 1){
            ++counter;
            switch(direction){
                case 0:
                    if(y < matrix[0].length - 1 && visited[x][y + 1] == false){
                        ++y;
                    }
                    else{
                        ++direction;
                        ++x;
                    }
                    break;
                case 1:
                    if(x < matrix.length - 1 && visited[x + 1][y] == false){
                        ++x;
                    }
                    else{
                        ++direction;
                        --y;
                    }
                    break;
                case 2:    
                    if(y > 0 && visited[x][y - 1] == false){
                        --y;
                    }
                    else{
                        ++direction;
                        --x;
                    }
                    break;
                case 3:
                    if(x > 0 && visited[x - 1][y] == false){
                        --x;
                    }
                    else{
                        direction = 0;
                        ++y;
                    }
                    break;
            }
            visited[x][y] = true;
            ret.add(matrix[x][y]);
        }
        
        return ret;
    }
}
