package interview.prep.leetcode.july20;
/*
 * Word Search

Solution
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
        if (word ==null)
            return false; 
        
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[i].length; j++){
                if(dfs(i,j,0,board,word))
                	return true;
            }
        }
        return false;
    }
    private boolean dfs(int i, int j, int pos, char[][] board, String word){
        if(pos == word.length()) //prior call passed - so terminate recursion
        	return true; 
        
    	if(i<0  || i >= board.length || j<0 || j >= board[i].length 
                || board[i][j]!=word.charAt(pos) || board[i][j] =='-')
            return false;
        
        char temp = board[i][j]; 
        board[i][j] = '-';
        boolean found =		dfs(i-1,j,pos+1,board,word) 
        				|| 	dfs(i+1,j,pos+1,board,word) 
                        || 	dfs(i,j-1,pos+1,board,word) 
                        || 	dfs(i,j+1,pos+1,board,word);
        
        board[i][j] = temp; 
        return found; 
    }
}
