
public class StringMultiply {
	
	public static String multiply(String num1, String num2) {
		char[] num3 = new char[200];
        int i = num1.length()-1;
        int j = num2.length()-1;
        int k = num3.length-1;
        int l = 0;
        int carry = 0;
        
        for(int x=0;x<num3.length;x++){
        	num3[x] = 0;
        }
        
        while(i>=0) {
            k = (num3.length-1)-l;
            int x = num1.charAt(i)-48;
            
            while(j>=0) {
                int y = num2.charAt(j)-48;
                int temp = num3[k] + x*y + carry;
                num3[k] = (char) (temp%10);
                carry = temp/10;
                j--;
                k--;
            }
            
            if(carry > 0){
                num3[k] = (char) carry;
                carry = 0;
            }
            
            j = num2.length()-1;
            i--;
            l++;
        }
        
        int temp = num3[k];
        while(temp > 0){
            num3[k] = (char) (temp%10);
            temp = temp/10;
            k--;
        }
        
        boolean flag = false;
        int init = k+1;
        //to handle a case in which one od num1 or num2 are numbers starting with one or more 0's
        //then we have to check for 0's in the beginning of our answer and remove from the final answer
        for(int x=0;x<num3.length;x++) {
            if(!flag && num3[x] != 0){
                flag = true;
                init = x;
            }
            num3[x] = (char) (num3[x] + 48);
        }
        
        return new String(num3, init, num3.length-init);
        
    }
	
	public static void main(String[] args) {
		System.out.println("the result of multiplication of " + args[0] + "x" + args[1] + "=" + multiply(args[0],args[1]));
	}

}
