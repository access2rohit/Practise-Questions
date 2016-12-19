public class Solution {

	public static void main(String args[]){
		isInterleave(args[0], args[1], args[2]);
	}
	public int isInterleave(String a, String b, String c) {
	    char[] s1 = a.toCharArray();
	    char[] s2 = b.toCharArray();
	    char[] s3 = c.toCharArray();
	    int i,j,k;
	    i=j=k=0;
	    int result = 0;
	    
	    if(s1.length + s2.length != s3.length) {
	        System.out.println("exit 1");
	        return 0;
	    }
	    
	    int[][] arr = new int[s1.length+1][s2.length+1];
	    
	    for(i=0;i<s1.length+1;i++){
	        for(j=0;j<s2.length+1;j++){
	            arr[i][j]=-1;
	        }
	    }
	    
	    for(i=0;i<s1.length+1;i++){
	        
	        for(j=0;j<s2.length+1;j++){
	            
	            if(i-1 >= 0 && s1[i-1] == s3[i+j-1] && arr[i][j] < (arr[i-1][j] + 1)) {
	                arr[i][j] = arr[i-1][j] + 1;
	            } 
	            
	            if(j-1 >= 0 && s2[j-1] == s3[i+j-1] && arr[i][j] < (arr[i][j-1] + 1)) {
	                arr[i][j] = arr[i][j-1] + 1;
	            }
	            
	            
	        }
	    }
	    
	   // for(i=0;i<s1.length+1;i++){
	   //     for(j=0;j<s2.length+1;j++){
	   //         System.out.print(arr[i][j] + "\t");
	   //     }
	   //     System.out.print("\n");
	   // }
	    System.out.println("i=" + i);
	    System.out.println("j=" + j);
	    System.out.println("s3.length=" + s3.length + ", arr[i-2][j-2]=" + arr[s1.length][s2.length]);
	    result = arr[i-2][j-2] == s3.length-1 ? 1 : 0;
	    return result;
	}
}
