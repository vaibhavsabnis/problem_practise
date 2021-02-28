package interview.prep.dailybyte;
/*
This question is asked by Amazon.
Given a string representing the sequence of moves a robot vacuum makes,
return whether or not it will return to its original position.
 The string will only contain L, R, U, and D characters,
  representing left, right, up, and down respectively.


Ex: Given the following strings...

"LR", return true
"URURD", return false
"RUULLDRD", return true
 */
public class VacuumCleanerRoutine {
    public boolean returnToOriginal(String route){
        if(route ==null || route.isEmpty())
            return true;
        int x=0,y=0;
        for(char c: route.toCharArray()){
            if(c =='U') y++;
            else if(c=='D') y--;
            else if(c=='R') x++;
            else if(c=='L') x--;

        }
        return (x==0 && y==0);
    }

    public static void main(String[] args) {
        VacuumCleanerRoutine vc = new VacuumCleanerRoutine();
        String[] routes = {"LR", "URURD","RUULLDRD"};
        for(String route: routes)
            System.out.println(vc.returnToOriginal(route));
    }

}
