import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Trie {

    public class Node {
        Map<Character, Node> children;
        int wordCount;
        boolean isCompleteWord;
        
        Node() {
            this.children = new HashMap<Character, Node>();
            this.wordCount = 0;
            this.isCompleteWord = false;
        }
    }
    public static void main(String[] args) {
        Trie s = new Trie();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node trie = s.new Node();
        
        for(int i = 0; i < n; i++){
            String op = in.next();
            String contact = in.next();
            String prevContact;
            Node t = trie;
            
            if("add".equals(op)) {
                for(int j=0;j<contact.length();j++) {
                    Node newNode = s.new Node();
                    char c = contact.charAt(j);
                    if(!t.children.containsKey(c)) {
                        t.children.put(c, newNode);
                    }
                    t = t.children.get(c);
                    t.wordCount++;
                }
                t.isCompleteWord = true;
            } else if("find".equals(op)) {
                for(int j=0;j<contact.length();j++) {
                    char c = contact.charAt(j);
                    if(t.children.containsKey(c)) {
                        t = t.children.get(c);
                    } else {
                        t=null;
                        break;
                    }
                }
                System.out.println(t==null ? 0 : t.wordCount);
            }
            prevContact = contact;
        }
    }
}
