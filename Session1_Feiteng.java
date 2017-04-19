import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Session1_Feiteng
{

	public static void main( String[] args )
	{
		Session1_Feiteng s = new Session1_Feiteng();
		int[] n = { 0, 0, 0, 0 };
		System.out.println( s.threeSum( n ) );

	}

	// 1. given a set of integer number, find duplicate among them.
	// Input : arr[] = {1, 5, 2, 1, 4, 3, -1, 7, 2, 8, 9, 5}
	// Output : Duplicate item are : 5 2 1
	// Can you do it in O(n) time?

	int[] q1( int[] a )
	{
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for ( int k : a )
		{
			if ( set.contains( k ) )
				list.add( k );
			set.add( k );
		}
		int[] output = new int[list.size()];
		for ( int i = 0; i < output.length; i++ )
			output[i] = list.get( i );
		return output;
	}

	// 2. (3 SUM Problem) Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
	// Find all unique triplets in the array which gives the sum of zero.
	// Note: The solution set must not contain duplicate triplets.
	// For example, given array S = [-1, 0, 1, 2, -1, -4],
	// A solution set is:
	// [
	// [-1, 0, 1],
	// [-1, -1, 2]
	// ]

	List<List<Integer>> threeSum( int[] n )
	{
		Arrays.sort( n );
		List<List<Integer>> retList = new ArrayList<>();
		List<Integer> list = new ArrayList<>(), temp;

		return retList;
	}

	//
	// 3. Given a graph shown below, construct your own graph, then output all the nodes based on the constructed graph using BFS, DFS or topological
	// sort;
	// input:
	//
	// Output: 0, 1, 2, 3, 4, 5, 6 (the output order doesn’t matter)
	// You can use vector, list or map to construct your graph,
	// For instance, we can construct this graph using vector as follows:
	// vector<int> nodes = {0, 1, 2, 3, 4, 5, 6};
	// vector<int> neighbors[7];
	// neighbors[0] = {1, 2};
	// neighbors[1] = {0, 2, 3, 4,6};
	// neighbors[2] = {0, 1};
	// neighbors[3] = {1, 5};
	// neighbors[4] = {1, 5};
	// neighbors[5] = {3, 4};
	// neighbors[6] = {1};
	// Hint: you can use hashSet to store all the visited nodes.

	void printNeighbour( int[][] graph )
	{

	}

	// 4. Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to
	// T.
	// Each number in C may only be used once in the combination.
	// Note:
	// All numbers (including target) will be positive integers.
	// The solution set must not contain duplicate combinations.
	// For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
	// A solution set is:
	// [
	// [1, 7],
	// [1, 2, 5],
	// [2, 6],
	// [1, 1, 6]
	// ]
}
