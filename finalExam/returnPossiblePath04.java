public class returnPossiblePath04 {
    // Time complexity: O(M*N)
    static int count = 0;
    public static void main(String[] args) {
       // int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] obstacleGrid = {{0,1},{0,0}};

        System.out.println(returnPossiblePath(obstacleGrid));
    }
    public static int returnPossiblePath (int[][] obstacleGrid) {
        helper(0,0,obstacleGrid);
        return count;
    }

    public static void helper (int x, int y, int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (x >= row || y >= col || obstacleGrid[x][y] == 1) {
            return;
        }
        if (x == row - 1 && y == col - 1) {
            count++;
            return;
        }
        helper(x+1, y, obstacleGrid);
        helper(x, y+1, obstacleGrid);
    }

}
