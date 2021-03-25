package interview.prep.dailybyte;
/*
This question is asked by Google. Given a string, return whether or not it uses capitalization correctly. A string correctly uses capitalization if all letters are capitalized, no letters are capitalized, or only the first letter is capitalized.

Ex: Given the following strings...

"USA", return true
"Calvin", return true
"compUter", return false
"coding", return true
 */
public class CorrectCapitalization {
    public boolean _detectCapitalUse(String word) {
        if(word ==null || word.length() <=1)
            return true;

        if(Character.isLowerCase(word.charAt(0)))
            return false;

        boolean hasMixCase = Character.isLowerCase(word.charAt(1));

        for(int i=1; i<word.length(); i++){
            char curr = word.charAt(i);
            if(hasMixCase){
                if(!Character.isLowerCase(curr))
                    return false;
            }else{
                if(!Character.isUpperCase(curr))
                    return false;
            }

        }
        return true;
    }

    public boolean detectCapitalUse(String word) {
        if(word ==null || word.length() <=1)
            return true;

        char first = word.charAt(0);
        char sec = word.charAt(1);

        boolean hasMixCase = false;
        boolean hasAllCaps = false;
        boolean hasAllSmall = false;

        if(Character.isUpperCase(first) && Character.isLowerCase(sec))
            hasMixCase = true;
        else if(Character.isLowerCase(first) && Character.isLowerCase(sec))
            hasAllSmall = true;
        else if (Character.isUpperCase(first) && Character.isUpperCase(sec))
            hasAllCaps = true;

        if(!hasMixCase && !hasAllCaps && ! hasAllSmall)
            return false;

        for(int i=2; i<word.length(); i++){
            char curr = word.charAt(i);
            char prior = word.charAt(i-1);
            if(hasMixCase){
                if(!Character.isLowerCase(curr))
                    return false;
            }else{
                if(Character.isUpperCase(curr) != Character.isUpperCase(prior))
                    return false;
            }
        }
        return true;
    }
}
