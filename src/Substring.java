
public class Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strstr("GeeksForGeeks", "For"));

	}
	
	public static int strstr(String str, String target) {
		int flag = -1;
		int i,j;
		for(i=0;i<(str.length()-target.length());i++) {
		    for(j=0;j<target.length();j++) {
		        if(str.charAt(i+j) != target.charAt(j)){
		            break;
		        }
		    }
		    if(j==target.length()){
		        flag = i;
		        break;
		    }
		}
		return flag;
	}

}
