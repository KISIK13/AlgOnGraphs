package lab2new_v2;
import java.util.*;
public class test_a {

	public static void main(String[] args) 
	{
		int[][] graph1 = {
                {0, 1, 1, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 1, 1},
                {0, 1, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0}
        };
		int[][] graph2 = {
                {0, 2, 1, 4, 0, 6, 0},
                {2, 0, 0, 1, 3, 0, 0},
                {1, 0, 0, 2, 0, 4, 0},
                {4, 1, 2, 0, 0, 0, 1},
                {0, 3, 0, 0, 0, 0, 4},
                {6, 0, 4, 0, 0, 0, 7},
                {0, 0, 0, 1, 4, 7, 0}
        };
		int[][] graph3 = {
                {0, 1, 2, 4, 0, 0, 0},
                {1, 0, 0, 2, 5, 0, 0},
                {2, 0, 0, 7, 0, 4, 1},
                {4, 2, 7, 0, 1, 0, 1},
                {0, 5, 0, 1, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0}
        };
		int[][] graph4 = {
                {0, 2, 1, 3, 0, 6, 0},
                {2, 0, 0, 1, 3, 0, 0},
                {1, 0, 0, 2, 0, 3, 0},
                {3, 1, 2, 0, 0, 0, 1},
                {0, 3, 0, 0, 0, 0, 4},
                {6, 0, 3, 0, 0, 0, 7},
                {0, 0, 0, 1, 4, 7, 0}
        };
		System.out.println(graph_a.dfs(graph1, 0));
		System.out.println(graph_a.bfs(graph1, 0));
		System.out.println(graph_a.Dijkstra(graph2, 3));
		System.out.println(Arrays.deepToString(graph_a.Floyd(graph3)));
		System.out.println(graph_a.Prima(graph4, 4));
		 System.out.println( graph_a.Kruskal(graph4, 4));
	}

}
