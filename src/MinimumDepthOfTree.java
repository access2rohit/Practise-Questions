import java.util.Queue;
import java.util.LinkedList;


public class MinimumDepthOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root;
		MinimumDepthOfTree td = new MinimumDepthOfTree();
		root = td.new Node(10);
		root.left = td.new Node(20);
		root.right = td.new Node(30);
		root.left.left = td.new Node(40);
		root.left.right = td.new Node(60);
		
		System.out.println(minDepth(root));
	}
	
	class Node {
		int data;
		Node left,right;
		
		Node(int data){
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public static int minDepth(Node root) {
		//boolean flag = true;
        Queue<Node> q = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();
        if(root == null){
            return 0;
        } else if (root.left == null && root.right == null){
            return 1;
        }
        int depth = 1;
        q.add(root);
        Node popped;
        try{
            //while(flag){
                while(!q.isEmpty()){
                    popped = q.remove();
                    if(popped.left == null && popped.right == null){
                        //flag = false;
                        break;
                    }
                    if(popped.left != null){
                        q2.add(root.left);
                    }
                    if(popped.right != null){
                        q2.add(root.right);
                    }
                    
                    if(q.isEmpty())
                    {
                    	depth++;
                    	while(!q2.isEmpty())
                    	{
                            q.add(q2.remove());
                    	}                    
                    }                
            }
        } catch (Exception e) {
            
        }
        // Your code here
        // System.out.println("efbebeas");
        return depth;
    }

}
