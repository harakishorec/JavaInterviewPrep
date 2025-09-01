package Graph;

//DFS
public class NoOfIsland {

    private static boolean[][] visited;
    private static int[][] grid;

    public NoOfIsland(int[][] grid){
        this.grid = grid;
    }

    public static void main(String[] args) {
        int gridMat[][] = {
                {1,1,0,0},
                {0,1,0,1},
                {0,1,0,0},
                {0,0,0,1}
        };

        NoOfIsland island = new NoOfIsland(gridMat);
        System.out.println("Number of Island: "+island.numberOfIsland());
        System.out.println("Max Area of Island: "+island.maxArea());
    }

    public int maxArea(){
        if(null == grid || grid.length == 0 || grid[0].length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        int area, largestArea = -1;

        for(int i=0; i<row; i++){
            for(int j =0; j<col; j++){
                area = maxAreaDFS(i,j);
                largestArea = Math.max(largestArea,area);
            }
        }
        return largestArea;
    }

    public int maxAreaDFS(int i, int j){

        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] || grid[i][j] == 0) return 0;

        visited[i][j] = true;

        int count = 1;
        count = count + maxAreaDFS(i-1, j);
        count = count + maxAreaDFS(i+1, j);
        count = count + maxAreaDFS(i, j-1);
        count = count + maxAreaDFS(i, j+1);


        return count;
    }

    public int numberOfIsland(){
        if(null == grid || grid.length == 0 || grid[0].length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        int n =0;

        for(int i = 0; i< row; i++){
            for(int j =0; j<col; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    n++;
                    numberOfIslandDFS(i,j);
                }
            }
        }
        return n;
    }

    public void numberOfIslandDFS(int i, int j){
        if(i<0 || i>= grid.length || j<0 || j>= grid[0].length || visited[i][j] || grid[i][j] == 0) return;

        visited[i][j] = true;
        numberOfIslandDFS(i-1,j);
        numberOfIslandDFS(i+1,j);
        numberOfIslandDFS(i,j-1);
        numberOfIslandDFS(i,j+1);

    }
}
