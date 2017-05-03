import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S3_Stack_FL
{
	// Easy
	// 1.Valid Parentheses
	// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	// https://leetcode.com/problems/valid-parentheses/#/description
	//
	public boolean isValid( String s )
	{
		Stack<Character> stack = new Stack<>();
		for ( char c : s.toCharArray() )
		{
			if ( c == ')' || c == '}' || c == ']' )
				if ( stack.isEmpty() )
					return false;
			if ( c == '(' || c == '{' || c == '[' )
				stack.push( c );
			else
			{
				if ( c == ')' && stack.peek() != '(' )
					return false;
				if ( c == '}' && stack.peek() != '{' )
					return false;
				if ( c == ']' && stack.peek() != '[' )
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty() ? true : false;
	}

	// Extra Question: What if there is only '(', ')' in the string? Can you tell if it is valid or not using only constant extra space?
	public boolean isValidConstantSpace( String s )
	{
		int k = 0;
		for ( char c : s.toCharArray() )
		{
			if ( k < 0 )
				return false;
			if ( c == '(' )
				k++;
			else
				k--;
		}
		return k == 0 ? true : false;
	}

	// 2. Single Number
	// Given an array of integers, every element appears twice except for one. Find that single one.
	// Note:
	// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	// https://leetcode.com/problems/single-number/#/description
	//
	public int singleNumber( int[] nums )
	{
		int x = 0;
		for ( int n : nums )
			x ^= n;
		return x;
	}

	// 3. Power of Two
	// Given an integer, write a function to determine if it is a power of two.
	// https://leetcode.com/problems/power-of-two/#/description
	//
	public boolean isPowerOfTwo( int n )
	{
		if ( n <= 0 )
			return false;
		int k = 0;
		for ( int i = 0; i < 32; i++ )
		{
			k += n & 1;
			n >>= 1;
		}
		return k == 1 ? true : false;
	}

	// Medium
	// 3. Binary Tree Preorder Traversal
	// Given a binary tree, return the preorder traversal of its nodes' values.
	// For example:
	// Given binary tree {1,#,2,3},
	// 1
	// \
	// 2
	// /
	// 3
	// return [1,2,3].
	// https://leetcode.com/problems/binary-tree-preorder-traversal/#/description
	//
	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode( int x )
		{
			val = x;
		}
	}

	public List<Integer> preorderTraversal( TreeNode root )
	{
		List<Integer> list = new ArrayList<>();
		preOrderHelper( root, list );
		return list;
	}

	void preOrderHelper( TreeNode root, List<Integer> list )
	{
		if ( root == null )
			return;
		list.add( root.val );
		preOrderHelper( root.left, list );
		preOrderHelper( root.right, list );
	}

	public List<Integer> preorderTraversalIterative( TreeNode root )
	{
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.add( root );
		while ( !stack.isEmpty() )
		{
			TreeNode tmp = stack.pop();
			if ( tmp != null )
			{
				list.add( tmp.val );
				stack.add( tmp.right );
				stack.add( tmp.left );
			}
		}
		return list;
	}

	// 4. Evaluate Reverse Polish Notation
	// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	// Valid operators are +, -, *, /. Each operand may be an integer or another expression.
	// Some examples:
	// ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	// ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	// https://leetcode.com/problems/evaluate-reverse-polish-notation/#/description
	//
	public int evalRPN( String[] tokens )
	{
		Stack<Integer> stack = new Stack<>();
		for ( String s : tokens )
			switch ( s )
			{
			case "+":
				stack.push( stack.pop() + stack.pop() );
				break;
			case "-":
				stack.push( -stack.pop() + stack.pop() );
				break;
			case "*":
				stack.push( stack.pop() * stack.pop() );
				break;
			case "/":
				int a = stack.pop(), b = stack.pop();
				stack.push( b / a );
				break;
			default:
				stack.push( Integer.valueOf( s ) );
			}
		return stack.peek();
	}
	//
	// 习题补充： from Jilang Miao
	// https://www.hackerrank.com/domains/data-structures/stacks

}
