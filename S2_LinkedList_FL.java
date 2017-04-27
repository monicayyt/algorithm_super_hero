public class S2_LinkedList_FL
{
	class ListNode
	{
		int val;
		ListNode next;

		ListNode( int x )
		{
			val = x;
			next = null;
		}
	}

	// Easy
	// 1.Delete Node in a Linked List
	// Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
	// Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after
	// calling your function.
	// https://leetcode.com/problems/delete-node-in-a-linked-list/#/description

	public void deleteNode( ListNode node )
	{
		// replace current node with next node and remove next node
		if ( node != null )
		{
			node.val = node.next.val;
			node.next = node.next.next;
		}
	}

	// what I expected question to be
	void deleteNode2( ListNode head, ListNode node )
	{

		ListNode t = head;
		while ( t.next != node )
			t = t.next;
		t.next = t.next.next;
	}

	// 2. Reverse Linked List
	// Reverse a singly linked list.
	// For input: 1 -> 2 -> 3 -> 4 -> 5 -> 6
	// output should be 6 -> 5 -> 4 -> 3 -> 2 -> 1
	// Can you do it in O(n) without using extra space.
	// https://leetcode.com/problems/reverse-linked-list/#/description/

	// modify original list
	public ListNode reverseList( ListNode head )
	{
		ListNode newNode = new ListNode( 0 ), tmp = head;
		while ( tmp != null )
		{
			ListNode headNext = newNode.next, tmpNext = tmp.next;
			newNode.next = tmp;
			tmp.next = headNext;
			tmp = tmpNext;
		}
		return newNode.next;
	}

	// without modifying original list.
	// difference to above is that new operation is always slower
	// advantage is it's easier to think and implement
	public ListNode reverseListNoModification( ListNode head )
	{
		ListNode newNode = new ListNode( 0 ), prev = newNode, tmp = head;
		while ( tmp != null )
		{
			prev = newNode.next;
			newNode.next = new ListNode( tmp.val );
			newNode.next.next = prev;
			prev = newNode.next;
			tmp = tmp.next;
		}
		return newNode.next;
	}

	// 3. Merge Two Sorted Lists
	// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two
	// lists.
	// For input: 1 -> 2 -> 5 -> 9,
	// 6 -> 8
	// Output should be 1 -> 2 -> 5 -> 6 -> 8 -> 9
	// https://leetcode.com/problems/merge-two-sorted-lists/#/description
	public ListNode mergeTwoLists( ListNode l1, ListNode l2 )
	{
		ListNode newNode = new ListNode( 0 ), tmp = newNode;
		while ( l1 != null && l2 != null )
		{
			if ( l1.val < l2.val )
			{
				tmp.next = new ListNode( l1.val );
				l1 = l1.next;
			}
			else
			{
				tmp.next = new ListNode( l2.val );
				l2 = l2.next;
			}
			tmp = tmp.next;
		}
		if ( l1 != null )
			tmp.next = l1;
		if ( l2 != null )
			tmp.next = l2;

		return newNode.next;
	}

	// 4.Linked List Cycle
	// Given a linked list, determine if it has a cycle in it.
	// Follow up:
	// Can you solve it without using extra space?
	// https://leetcode.com/problems/linked-list-cycle/#/description
	public boolean hasCycle( ListNode head )
	{
		ListNode s = head, f = head;
		while ( f != null && f.next != null )
		{
			s = s.next;
			f = f.next.next;
			if ( s == f )
				return true;
		}
		return false;
	}

	//
	// Medium
	// 5.Linked List Cycle II
	// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	// Note: Do not modify the linked list.
	// Follow up:
	// Can you solve it without using extra space?
	// https://leetcode.com/problems/linked-list-cycle-ii/#/description
	public ListNode detectCycle( ListNode head )
	{
		ListNode s = head, f = head;
		while ( f != null && f.next != null )
		{
			s = s.next;
			f = f.next.next;
			if ( s == f )
			{
				ListNode t = head;
				while ( s != t )
				{
					s = s.next;
					t = t.next;
				}
				return s;
			}
		}
		return null;

	}
}