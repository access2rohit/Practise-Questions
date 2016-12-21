
public class TreeDiameter {
	
	class Node
	{
		int data;
		Node left, right;

		public Node(int item)
		{
			data = item;
			left = right = null;
		}
	}

	// A utility class to pass heigh object
	class Height
	{
		int h;
	}

	/* Class to print the Diameter */
	class BinaryTree
	{
		Node root;

		/* define height =0 globally and call diameterOpt(root,height)
		from main */
		int diameterOpt(Node root, Height height)
		{
			/* lh --> Height of left subtree
			rh --> Height of right subtree */
			Height lh = new Height(), rh = new Height();

			if (root == null)
			{
				height.h = 0;
				return 0; /* diameter is also 0 */
			}
			
			/* ldiameter --> diameter of left subtree
			rdiameter --> Diameter of right subtree */
			/* Get the heights of left and right subtrees in lh and rh
			And store the returned values in ldiameter and ldiameter */
			lh.h++;	 rh.h++; 
			int ldiameter = diameterOpt(root.left, lh);
			int rdiameter = diameterOpt(root.right, rh);

			/* Height of current node is max of heights of left and
			right subtrees plus 1*/
			height.h = Math.max(lh.h, rh.h) + 1;

			return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
		}

		/* A wrapper over diameter(Node root) */
		int diameter()
		{
			Height height = new Height();
			return longestDiameter(root, height);
		}
		
		public int longestDiameter(Node root, Height height) {
	        int leftDiameter, rightDiameter;
	        Height leftHeight, rightHeight;
	        leftHeight = new Height();
	        rightHeight = new Height();
	        // leftHeight.h = 0;
	        // rightHeight.h = 0;
	        
	        if(root.left == null && root.right == null){
	            height.h = 1;
	            System.out.println("Node value=" + root.data + " h=" +height.h);
	            return 1;
	        } else {   
	            leftDiameter = root.left != null ? longestDiameter(root.left, leftHeight) : 0;
	            rightDiameter = root.right != null ? longestDiameter(root.right, rightHeight) : 0;
	            height.h = Math.max(leftHeight.h, rightHeight.h) + 1;
	            System.out.println("Node value=" + root.data + " ld=" + leftDiameter + ", rd=" + 
	                rightDiameter + ", h=" + height.h + ", lh=" + leftHeight.h + ", rh=" + rightHeight.h);
	            return Math.max(leftHeight.h + rightHeight.h + 1, Math.max(leftDiameter, rightDiameter));
	        }
	    }


	}

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		TreeDiameter td = new TreeDiameter();
		BinaryTree tree = td.new BinaryTree();
		tree.root = td.new Node(1);
		tree.root.left = td.new Node(2);
		tree.root.right = td.new Node(3);
		tree.root.left.left = td.new Node(4);
		tree.root.left.right = td.new Node(5);
		tree.root.right.right = td.new Node(6);

		System.out.println("The diameter of given binary tree is : "
						+ tree.diameter());
	}

}
