// Time complexity: O(i*i*j*j)
public class GetNumOfIslands02 {

    public static int getTheNumOfIslands(String[][] matrix){
        int count = 0;
        int r = matrix.length;
        if (r == 0) return count;
        int c = matrix[0].length;
        boolean[][] visited = new boolean[r][c];

        for(int i = 0 ; i < r; i++){
            for(int j = 0 ; j < c; j++){
                if( matrix[i][j]=="1" && visited[i][j] == false ){
                    count++;
                    setNeighboursVisited(matrix, visited, i, j);
                }
            }
        }

        return count;
    }

    private static void setNeighboursVisited(String[][] matrix, boolean[][] visited, int rowIndex, int colIndex){
        int row = matrix.length;
        if (row == 0) return;
        int col = matrix[0].length;

        if ( rowIndex < 0 || rowIndex >= row || colIndex < 0 || colIndex >= col
                || matrix[rowIndex][colIndex].equals("0") || visited[rowIndex][colIndex] == true){
            return;
        }
        visited[rowIndex][colIndex] = true;
        setNeighboursVisited(matrix, visited, rowIndex -1, colIndex);
        setNeighboursVisited(matrix, visited, rowIndex, colIndex -1);
        setNeighboursVisited(matrix, visited, rowIndex, colIndex + 1);
        setNeighboursVisited(matrix, visited, rowIndex + 1, colIndex );
    }
    public static void main(String[] args) {
        String[][] matrix = {
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };

        System.out.println(getTheNumOfIslands(matrix));
    }
}