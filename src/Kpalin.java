
public class Kpalin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isKPalin("acdcb", 1) ? "TRUE" : "FALSE");
	}
	
	public static boolean isKPalin(String str, int k) {
	    // Your code here
	    int len = str.length();
	    int[][] arr = new int[len+1][len+1];
	    
	    for(int i=0;i<len+1;i++) {
	        arr[0][i] = 0;
	        arr[i][i] = 0;
	        arr[i][0] = 0;
	    }
	    
	    for(int i=1;i<(len+1);i++) {
	        for(int j=1;(i+j)<(len+1);j++) {
	        	boolean eql = (str.charAt(j-1) == str.charAt(j+i-1));
	        	if(!eql){
	        		arr[j][j+i] = 1 + Math.min(arr[j+1][j+i], arr[j][j+i-1]);
	        	} else {
	        		
	        		arr[j][j+i] = j+1 <= j+i-1 ? arr[j+1][j+i-1] : 0;
	        	}
	        }
	    }
	    
	    boolean ans = arr[1][len] <= k && arr[1][len] != 0;
	    return ans;
    }

}
