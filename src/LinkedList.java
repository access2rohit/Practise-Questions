
public class LinkedList {
	
	public class Node {
		int value;
		Node next;
		
		Node() {}
		Node(int val, Node nxt) {
			this.value = val;
			this.next = nxt;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node start = createList(args);
		System.out.println("Original Linked List !!");
		printLinkedList(start);
		modifyLinkedList(start);
		
	}
	
	public static void modifyLinkedList(Node start) {
		Node curr = start;
		Node center;
		int i= curr != null ? 1 : 0;
		if (i==0)
			return;
		while(curr.next!= null) {
			curr=curr.next;
			i++;
		}
		
		int length = i;
		int mid = length/2 < (length+1)/2 ? (length+1)/2 : length/2;
		
		curr=start;
		for(i=1;i<mid;i++) {
			curr=curr.next;
		}
		center = curr;
		
		center.next = reverseLinkedList(center.next);
		System.out.println("After Mid-Reversal");
		printLinkedList(start);
		
		Node p1, p2, temp;
		p1 = start;
		p2 = center.next;
		Node centerNext = center.next;
		temp = null;
		boolean flag = true;
		while(p2 != null && p1 != centerNext){ 
			if (flag) {
				temp = p1;
				p1 = p1.next;
				temp.next = p2;
				flag = !flag;
			} else {
				temp = p2;
				p2 = p2.next;
				temp.next = p1;
				flag = !flag;
			}
		}

		if(p2 == null && p1 != centerNext) {
			p1.next = null;
			System.out.println("exit here !");
		}
		
		System.out.println("LinkedList after complete modification !");
		printLinkedList(start);
		
	}
	
	public static Node reverseLinkedList(Node start) {
		
		Node curr, prev, next;
		if(start == null) {
			return null;
		}
		curr = start;
		if(start.next != null)
			next = start.next;
		else 
			return start;
		prev = null;
		while(curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if(next != null)
				next = next.next;
			
		}
		
		return prev;
	}
	
	public static Node createList(String[] args) {
		LinkedList l = new LinkedList();
		Node start = l.new Node(Integer.parseInt(args[0]), null);
		Node prev = start;
		for (int i = 1;i<args.length;i++) {
			Node curr = l.new Node(Integer.parseInt(args[i]), null);
			prev.next = curr;
			prev = curr;
		}
		return start;
	}
	
	public static void printLinkedList(Node start) {
		Node curr = start;
		while(curr != null) {
			System.out.print(curr.value + "->");
			curr = curr.next;
		}
		System.out.print("null\n");
	}

}
