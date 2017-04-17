import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Session1_Feiteng
{

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

	public static void main( String[] args )
	{
		Session1_Feiteng s = new Session1_Feiteng();
		int[] n = { 0, 0, 0, 0 };
		System.out.println( s.threeSum( n ) );

	}

	List<List<Integer>> threeSum( int[] n )
	{
		Arrays.sort( n );
		List<List<Integer>> retList = new ArrayList<>();
		List<Integer> list = new ArrayList<>(), temp;
		for ( int m : n )
			list.add( m );
		Set<Integer> set = new HashSet<>();
		for ( int i = 0; i < list.size() - 2; i++ )
		{
			System.out.println( list );
			int value = list.get( i );
			if ( set.contains( value ) )
				continue;
			set.add( value );
			temp = new ArrayList<>( list );
			temp = list.subList( i + 1, list.size() );
			// temp.remove( i );
			List<List<Integer>> twosumList = twoSum( new HashSet<>( temp ), 0 - value );
			if ( twosumList.size() > 0 )
			{
				for ( List<Integer> twoList : twosumList )
					twoList.add( value );
				retList.addAll( twosumList );
			}
		}
		return retList;
	}

	List<List<Integer>> twoSum( Set<Integer> list, int target )
	{
		Set<Integer> set = new HashSet<>();
		List<List<Integer>> retList = new ArrayList<>();
		if ( list.size() < 2 )
			return retList;
		for ( int k : list )
		{
			if ( set.contains( target - k ) )
			{
				List<Integer> tmpList = new ArrayList<>();
				System.out.println( k );
				tmpList.add( k );
				tmpList.add( target - k );
				retList.add( tmpList );
			}
			set.add( k );
		}
		return retList;

	}
}
