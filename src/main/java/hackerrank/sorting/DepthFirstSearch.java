package hackerrank.sorting;

import java.util.Scanner;

public class DepthFirstSearch {

    int rows;
    int cols;
    int grid[][];

    public DepthFirstSearch(int rows, int cols, int grid[][]){
        this.rows = rows;
        this.cols = cols;
        this.grid = grid;
    }


    /*public static int getBiggestRegion(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, countCells(matrix, i, j));
            }
        }
        return max;
    }

    private static int countCells(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return 0;
        if (matrix[i][j] == 0) return 0;
        int count = matrix[i][j]--;
        count += countCells(matrix, i + 1, j);
        count += countCells(matrix, i - 1, j);
        count += countCells(matrix, i, j + 1);
        count += countCells(matrix, i, j - 1);
        count += countCells(matrix, i + 1, j + 1);
        count += countCells(matrix, i - 1, j - 1);
        count += countCells(matrix, i - 1, j + 1);
        count += countCells(matrix, i + 1, j - 1);
        return count;
    }*/


    public boolean isValid(int i, int j){
        if(i < 0 || j < 0 || i > rows-1 || j > cols -1){
            return false;
        }

        if(grid[i][j] < 1){
            return false;
        }

        return true;
    }

    public int dfs(int row, int col){
        if(!isValid(row, col)){
            return 0;
        }

        grid[row][col] = -1;
        int count = 1;

        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                count = count + dfs(row + i, col + j);
            }
        }

        return count;
    }

    public int solve(){
        int maxRegion = 0;
        for( int i=0; i < rows; i++ ) {
            for( int j=0; j < cols; j++ ) {

                int tempRegion = dfs(i, j);
                if (tempRegion > maxRegion) {
                    maxRegion = tempRegion;
                }

            }
        }

        return maxRegion;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        DepthFirstSearch solution = new DepthFirstSearch(n, m, grid);
        System.out.println(solution.solve());
    }
}
