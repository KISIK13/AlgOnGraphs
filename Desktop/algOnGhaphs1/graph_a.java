package lab2new_v2;
import java.util.*;


public class graph_a 
{
	static 	ArrayList<Integer> dfs(int[][] graph, int s)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		boolean[] Visit = new boolean[graph.length];
		DFS(graph,s,result,Visit);
		return result;
	}
	
	private static void DFS(int[][] graph,int x,ArrayList<Integer> result,boolean[] Visit)
	{
		result.add(x);
		Visit[x] = true;
		for(int i = 0; i < graph.length;i++)
			if(graph[x][i]!=0)
				if(Visit[i] == false)
					DFS(graph,i,result,Visit);
		
	}
	
	static ArrayList<Integer> bfs(int[][] graph , int s)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] Visit = new boolean[graph.length];
		queue.add(s);
		Visit[s] = true;
		while(queue.size()!=0)
		{
			int x=queue.removeFirst();
			result.add(x);
			for(int i = 0;i < graph.length;i++)
				if(graph[x][i]!=0)
					if(Visit[i] == false)
					{
						queue.add(i);
						Visit[i] = true;
					}
		}
		return result;
	}
	
	static ArrayList<Integer> Dijkstra(int[][] graph,int s)
	{
		ArrayList<Integer> D = new ArrayList<>();
		ArrayList<Boolean> U = new ArrayList<>();
		ArrayList<Integer> min = new ArrayList<>(); 
		for(int i = 0;i < graph.length;i++)
		{
			D.add(null);
			U.add(false);
		}
		D.set(s,0);
		while(U.contains(false))
		{
			for(int i = 0; i < D.size();i++)
				if(D.get(i)!=null && U.get(i) == false)
					min.add(i);
			int v = Collections.min(min);
			min.clear();
			U.set(v,true);
			for(int i = 0;i < graph.length;i++)
			{
				if(graph[v][i] != 0)
					if(D.get(i) == null || D.get(i) > D.get(v) + graph[v][i])
						D.set(i,D.get(v) + graph[v][i]);
			}
		}
		return D;
	}
	
	static int[][] Floyd(int[][] graph)
	{
		int[][] D = new int[graph.length][graph.length];
		int infinity = 6500;
		for(int i = 0;i < D.length;i++)
			for(int j = 0;j < D.length;j++)
				if(i!=j && graph[i][j] == 0)
					D[i][j] = infinity;
				else 
					D[i][j] = graph[i][j];
		for (int k = 0; k < graph.length; k++)                         
            for (int i = 0; i < graph.length; i++)
                for (int j = 0; j < graph.length; j++)
                    D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
		return D;
	}
	
	static ArrayList<String> Prima(int[][] graph, int s)
	{
		ArrayList<Integer> D = new ArrayList<>();
		ArrayList<Boolean> Visit = new ArrayList<>();
		ArrayList<Integer> Parent = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		int infinity = 6500;
		for(int i = 0;i < graph.length;i++)
		{
			D.add(infinity);
			Parent.add(null);
			Visit.add(false);
		}
		D.set(s,0);
		while(Visit.contains(false))
		{
			int n = 0;
			int min = infinity;
			for(int i = 0; i < D.size();i++)
			{
				if(D.get(i)<min && Visit.get(i) == false)
				{
					min = D.get(i);
					n=i;										
				}
			}
			Visit.set(n,true);
			for(int i = 0; i < graph.length;i++)
				if(graph[n][i] != 0)
					if(graph[n][i] < D.get(i) && Visit.get(i) == false)
					{
						D.set(i,graph[i][n]);				
						Parent.set(i,n);
					}
		}
		for(int i = 0;i < Parent.size();i++)				
			if(Parent.get(i)!=null)
				result.add("" + Parent.get(i) + "->" + i);
			else
				result.add("" + i + "-стартовая");
		return result;
	}
	
	static ArrayList<String> Kruskal(int[][] graph,int s)
	{
		ArrayList<Integer> D = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		ArrayList<Edge> edges = new ArrayList<>(); //массив класса Edge(ребра),каждый элемент содержит i,j,weight
		for(int i = 0;i < graph.length;i++)
			for(int j = 0;j < graph.length;j++)
				if(graph[i][j] != 0)
					edges.add(new Edge(i, j, graph[i][j])); //заполняем массив данными(нач вершина,кон вершина и ребро)
		Collections.sort(edges);
		for(int i = 0;i < graph.length;i++)
			D.add(i);
		for(Edge edge : edges)                              //пробегаем по всему массиву рёбер
		{
			if(D.get(edge.getI()) != D.get(edge.getJ()))
			{
				result.add(edge.toString());
				int temp = D.get(edge.getI());
				for(int i = 0;i < graph.length;i++)
				{
					if(D.get(i) == temp)
						D.set(i,D.get(edge.getJ()));
				}
			}
		}
		return result;
	}
}
