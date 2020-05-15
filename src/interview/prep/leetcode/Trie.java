package interview.prep.leetcode;

public class Trie {
	char data; 
	Trie[] children;
	String wordFormed;
	boolean hasChilden;
	boolean isWord;
	
    /** Initialize your data structure here. */
    public Trie() {
    	data = '0';
    	children = new Trie[26];
    	wordFormed = "";
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	Trie ct = this.children[word.charAt(0)-'a'];
    	if (ct==null) {
    		ct = new Trie();
    		this.children[word.charAt(0)-'a'] = ct;
    	}
        
    	ct.insertHelper(word, word, 0);
    }
    
    private void insertHelper(String word, String origWord, int currPos) {
    	if(word.isEmpty())
        	return; 
        
    	data = word.charAt(0);
    	wordFormed = origWord.substring(0,currPos+1);
    	
    	if(word.length()==1) {// as there is no subsequent character left - this is the final word
    		isWord = true;
    		return;
    	}
    	//continue to add children recursively
    	int pos = word.charAt(1)-'a';
    	Trie ct = this.children[pos]; 
    	if (ct == null) {
    		ct = new Trie();
    	}
    	
    	children[pos] = ct;
    	this.hasChilden = true;
    	children[pos].insertHelper(word.substring(1),origWord, currPos+1);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Trie ct = this.children[word.charAt(0)-'a'];
    	if (ct ==null)
    		return false;
    			
    	return ct.searchHelper(word, word,true);
    }
    
    private boolean searchHelper(String word, String origWord, boolean exactMatch) {

    	if(word.isEmpty())
    		return false;
    	
    	if(word.charAt(0)!= this.data)
    		return false;
    	
    	if(word.length() ==1) {//last character before no more recursion
    		if(!origWord.equals(this.wordFormed))
    			return false;
    		else {
    			if(exactMatch) {
    				return this.isWord; 
    			}else { //partial match
    				return true; 
    			}
    		}    		
    	}else {
    		if (!hasChilden)
    			return false; 
    		else {
	    		Trie child = this.children[word.charAt(1)-'a'];
	    		
	   			return child==null? false: child.searchHelper(word.substring(1), origWord, exactMatch);
    		}
    	}
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Trie ct = this.children[prefix.charAt(0)-'a'];
    	if (ct ==null)
    		return false;
    	
    	return ct.searchHelper(prefix, prefix,false);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
