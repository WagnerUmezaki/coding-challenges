import java.util.*;

public class Main {
    public static void main(final String[] args) {
        final int[][] matrix = {{1, 0, 0, 0, 0, 0},
                                {0, 1, 0, 1, 1, 1},
                                {0, 0, 1, 0, 1, 0},
                                {1, 1, 0, 0, 1, 0},
                                {1, 0, 1, 1, 0, 0},
                                {1, 0, 0, 0, 0, 1}};

        final int[][] expectedResult = {{1, 0, 0, 0, 0, 0},
                                        {0, 0, 0, 1, 1, 1},
                                        {0, 0, 0, 0, 1, 0},
                                        {1, 1, 0, 0, 1, 0},
                                        {1, 0, 0, 0, 0, 0},
                                        {1, 0, 0, 0, 0, 1}};
        printMatrix(matrix);
        removeIslands(matrix);
        System.out.println(""); 
        printMatrix(matrix);
        for(int i=0; i<expectedResult.length; i++) {
            for(int j=0; j<expectedResult[i].length; j++) {
                if(expectedResult[i][j] != matrix[i][j]) {
                    System.out.println("Wrong Answer!!");
                    return;
                }
            }   
        }

        System.out.println(""); 
        System.out.println("Right Answer!!");
    }

    private static void printMatrix(final int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }  
            System.out.println(""); 
        }
    }

    private static void removeIslands(final int[][] matrix) {
        final Set<String> pathCache = new HashSet<>();
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 1) {
                    if(!findPathToBorder(matrix, i, j, new HashSet<String>(), pathCache)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    private static boolean findPathToBorder(final int[][] matrix, int row, int col, Set<String> visited, Set<String> pathCache) {
        final String visitedCoordKey = row + "" + col; 
        if(pathCache.contains(visitedCoordKey)){
            return true;
        }

        if(matrix[row][col] == 1 && (row == 0 || col == 0 || row == matrix.length -1 || col == matrix[0].length -1)) {
            pathCache.add(visitedCoordKey);
            return true;
        }
        
        if(visited.contains(visitedCoordKey)) {
            return false;
        }

        visited.add(visitedCoordKey);
        if(matrix[row][col] == 1) {
            if(row-1 >= 0){
                boolean tryUp = findPathToBorder(matrix, row-1, col, visited, pathCache);
                if(tryUp) {
                    pathCache.add(visitedCoordKey);
                    return true;
                }
            }
            if(col+1 < matrix[0].length) {
                boolean tryRight = findPathToBorder(matrix, row, col+1, visited, pathCache);
                if(tryRight) {
                    pathCache.add(visitedCoordKey);
                    return true;
                }
            }
            if(row+1 < matrix.length) {
                boolean tryDown = findPathToBorder(matrix, row+1, col, visited, pathCache);
                if(tryDown) {
                    pathCache.add(visitedCoordKey);
                    return true;
                }
            }
            if(col-1 >= 0) {
                boolean tryLeft = findPathToBorder(matrix, row, col-1, visited, pathCache);
                if(tryLeft) {
                    pathCache.add(visitedCoordKey);
                    return true;
                }
            }
        }

        return false;
    }
}