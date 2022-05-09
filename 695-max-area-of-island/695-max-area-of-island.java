class Solution {
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if (grid[r][c] == 1){
                    max = Math.max(max, dfs(r, c, grid));
                }
                
            }
        }
        return max;
    }
    public int dfs (int r, int c, int[][] grid){
        if (r<0 || r>=grid.length || c<0 || c>=grid[0].length) return 0;
        if (grid[r][c] == 0) return 0;
        
        grid[r][c]=0;
        int count=1;
        for (int[] dir: dirs){
            count += dfs(r+dir[0], c+dir[1], grid);
        }
        return count;
    }

};