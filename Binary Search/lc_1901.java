// A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

// Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

// You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

// You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        int low = 0;
        int high = m - 1;
        
        while(low <= high){
            
            int mid = (low + high) / 2;
            
            int maxRow = 0;
            for(int i = 0; i < n; i++){
                if(mat[i][mid] > mat[maxRow][mid]){
                    maxRow = i;
                }
            }
            
            int left = mid - 1 >= 0 ? mat[maxRow][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRow][mid + 1] : -1;
            
            if(mat[maxRow][mid] > left && mat[maxRow][mid] > right){
                return new int[]{maxRow, mid};
            }
            
            else if(left > mat[maxRow][mid]){
                high = mid - 1;
            }
            
            else{
                low = mid + 1;
            }
        }
        
        return new int[]{-1,-1};
    }
}