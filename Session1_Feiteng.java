import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

	public List<List<Integer>> threeSum( int[] nums )
	{
		List<List<Integer>> triples = new ArrayList<>();
		Arrays.sort( nums );
		int i = 0, last = nums.length - 1;
		while ( i < last )
		{
			int a = nums[i], j = i + 1, k = last;
			while ( j < k )
			{
				int b = nums[j], c = nums[k], sum = a + b + c;
				if ( sum == 0 )
					triples.add( Arrays.asList( a, b, c ) );
				if ( sum <= 0 )
					while ( nums[j] == b && j < k )
						j++;
				if ( sum >= 0 )
					while ( nums[k] == c && j < k )
						k--;
			}
			while ( nums[i] == a && i < last )
				i++;
		}
		return triples;
	}

	//
	// 3. Given a graph shown below, construct your own graph, then output all
	// the nodes based on the constructed graph using BFS, DFS or topological
	// sort;
	// input:
	//
	// Output: 0, 1, 2, 3, 4, 5, 6 (the output order doesn't matter)
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
		// guaranteed graph is all connected
		// No separate loops
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for ( int i = 0; i < graph.length; i++ )
			map.put( i, new HashSet<>() );
		for ( int i = 0; i < graph.length; i++ )
		{
			for ( int j = 0; j < graph[0].length; j++ )
			{
				if ( i != j && graph[i][j] > 0 )
				{
					map.get( i ).add( j );
					map.get( j ).add( i );
				}
			}
		}
		printMap( 0, map, new HashSet<>() );
		System.out.println();
	}

	void printMap( int currentPos, Map<Integer, Set<Integer>> map, Set<Integer> visited )
	{
		for ( int k : map.get( currentPos ) )
		{
			if ( visited.contains( k ) )
				continue;
			visited.add( k );
			System.out.printf( "%d ", k );
			printMap( k, map, visited );
		}
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

	public List<List<Integer>> combinationSum2( int[] candidates, int target )
	{
		List<List<Integer>> retList = new ArrayList<>();
		Arrays.sort( candidates );
		getComb2( candidates, target, 0, retList, new ArrayList<>() );
		return retList;
	}

	void getComb2( int[] n, int target, int s, List<List<Integer>> rList, List<Integer> cList )
	{
		if ( target == 0 )
		{
			rList.add( new ArrayList<>( cList ) );
			return;
		}
		if ( target < 0 )
			return;
		for ( int i = s; i < n.length; i++ )
		{
			// had hard time coming up with solution for duplicate numbers
			// originally used Set to add all temp list
			// this if from top solution
			if ( i > s && n[i] == n[i - 1] )
				continue;
			cList.add( n[i] );
			getComb2( n, target - n[i], i + 1, rList, cList );
			cList.remove( cList.size() - 1 );
		}
	}
}
