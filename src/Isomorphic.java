import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Isomorphic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic(args[0], args[1]));
	}
	
	public static boolean isIsomorphic(String s, String t) {
        boolean flag = true;
        Map<String, String> characterToCharacterMapping = new HashMap<String, String>();
        Set<String> valueSet = new HashSet<String>();
        
        if(s.length() != t.length()) {
            return false;
        }
        
        for(int i=0;i<s.length();i++) {
            String s1 = String.valueOf(s.charAt(i)).trim();
            String t1 = String.valueOf(t.charAt(i)).trim();
            System.out.println("s1=" + s1 + ", t1=" + t1 + " and containskey(s1) = " + characterToCharacterMapping.containsKey(s1) );
            if( ( characterToCharacterMapping.containsKey(s1) && !t1.equals(characterToCharacterMapping.get(s1)) ) || 
            		(!characterToCharacterMapping.containsKey(s1) && valueSet.contains(t1))){
                return false;
            } else if(!characterToCharacterMapping.containsKey(s1)) {
                characterToCharacterMapping.put(s1, t1);
                valueSet.add(t1);
            }
        }
        
        return flag;
    }

}
