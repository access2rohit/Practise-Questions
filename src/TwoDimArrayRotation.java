
public class TwoDimArrayRotation {

	public static void main(String[] args) {
	    
		int n = Integer.parseInt(args[0]);
	    int[][] arr = new int[n][n];
	    
	    int l = 1;
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++) {
	            if(l <= n*n) {
	                arr[i][j] = Integer.parseInt(args[l]);
	                l++;
	            }
	        }
	    }
	    
	    System.out.println("Original Matrix");
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++) {
                System.out.print(arr[i][j] + " ");
	        }
	    }
	    
	    //mirror against diagonal
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++) {
	            if(i < j) {
	            	System.out.println("\n(i,j)=" + arr[i][j] + ", (j,i)=" + arr[j][i]);
	                int temp = arr[i][j];
	                arr[i][j] = arr[j][i];
	                arr[j][i] = temp;
	                System.out.println("(i,j)=" + arr[i][j] + ", (j,i)=" + arr[j][i]);
	            }
	        }
	    }
	    
	    System.out.println("\nAfter mirroring against diagonal ");
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++) {
                System.out.print(arr[i][j] + " ");
	        }
	    }
	    
	    //mirror against central column
	    int mirror = n-1;
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n/2;j++) {
                arr[i][j] = arr[i][j] + arr[i][mirror-j];
                arr[i][mirror-j] = arr[i][j] - arr[i][mirror-j];
                arr[i][j] = arr[i][j] - arr[i][mirror-j];
	        }
	    }
	    
	    System.out.println("\nAfter Mirroring against central column");
	    for(int i=0;i<n;i++) {
	        for(int j=0;j<n;j++) {
                System.out.print(arr[i][j] + " ");
	        }
	    }
	    
	}

}
