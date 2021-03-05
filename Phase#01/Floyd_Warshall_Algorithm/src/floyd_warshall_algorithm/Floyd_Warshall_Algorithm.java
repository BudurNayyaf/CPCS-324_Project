
/*
Zuhra Osman Mohamed 
Bodor Nayaf Alamri
Shuroog Abdulmajed Alshaikh
 */

package floyd_warshall_algorithm;

public class Floyd_Warshall_Algorithm {

    public static void main(String[] args) {

        //Fill the matrix with INF and the diagonal with zerors       
        int[][] graph = new int[10][10];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {

                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        //Enter weights for edges that have a weight not equal to INF
        graph[0][1] = 10;
        graph[0][5] = 5;

        graph[1][2] = 3;
        graph[1][4] = 3;

        graph[2][3] = 4;
        graph[2][7] = 5;

        graph[3][8] = 4;

        graph[4][2] = 4;
        graph[4][6] = 2;

        graph[5][1] = 3;
        graph[5][9] = 2;

        graph[6][3] = 7;

        graph[7][3] = 4;
        graph[7][8] = 3;

        graph[9][1] = 6;
        graph[9][6] = 8;

        //Print Matrix before applies Floyd's Algorithm on it.
        System.out.println("Matrix: \n");
        printMatrix(graph);

        //Call Floyd's function
        Floyd(graph);

        //Print the distance matrix of shortest path lengths.
        System.out.println("Final Distance Matrix: \n");
        printMatrix(graph);

    }
    //---------------------------------------------------------------------------

    // Print adjacency matrix
    public static void printMatrix(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                //If the value is the largest integer value in java, print the INF instead of printing it.
                if (graph[i][j] == Integer.MAX_VALUE) {
                    System.out.printf("%-7s", "INF");
                } else {
                    System.out.printf("%-7d", graph[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    //---------------------------------------------------------------------------
    public static void Floyd(int[][] graph) {
        System.out.println("\n--------------------------- Floyd's Algorithm ---------------------------\n");
        //Print the weight matrix of the graph
        System.out.println("D0: \n");        
        printMatrix(graph);
        System.out.println("------------------------------------------------------------------\n");
        //K= number of iteration = numbers of intermediate vertices in the shortest path between me and j.
        for (int k = 0; k < graph.length; k++) {
            //i= index of row, j= index of column
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    /*We made this condition to avoid negative value and to get correct results, 
                    because in java MAX_VALUE + X == Integer. MIN_VALUE + (X-1)*/
                    if ((graph[i][k] + graph[k][j]) < graph[i][j] && graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
            //Print matrix after each iteration           
            System.out.println("D" + (k + 1) + ": \n");
            printMatrix(graph);
            System.out.println("------------------------------------------------------------------\n");
        }
    }
}
