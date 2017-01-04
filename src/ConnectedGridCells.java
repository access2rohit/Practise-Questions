import java.util.*;

public class ConnectedGridCells {
    
    public static int getBiggestRegion(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] visited = new int[r][c];
        for(int i=0;i<r;i++) {
            Arrays.fill(visited[i], 0);
        }
        int max = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == 1){
                    int t = getRegion(matrix, i ,j);
                    if(max < t)
                        max = t;
                }
            }
        }
        return max;
    }
    
    public static int getRegion(int[][] matrix, int i, int j) {
        int count = 0;
        if(i>=0 && i<matrix.length && j>=0 && j<matrix[0].length && matrix[i][j] == 1){
            matrix[i][j]--;
            count++; 
            count = count + getRegion(matrix, i-1, j);
            count = count + getRegion(matrix, i+1, j);
            count = count + getRegion(matrix, i, j-1);
            count = count + getRegion(matrix, i, j+1);
            count = count + getRegion(matrix, i-1, j-1);
            count = count + getRegion(matrix, i+1, j+1);
            count = count + getRegion(matrix, i-1, j+1);
            count = count + getRegion(matrix, i+1, j-1);
        }
        return count;
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
        System.out.println(getBiggestRegion(grid));
    }
}
