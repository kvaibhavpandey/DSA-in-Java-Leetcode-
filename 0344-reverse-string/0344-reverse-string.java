class Solution {
    public void reverseString(char[] s) {
        int p1=0;
        int p2=s.length-1;
        char a;

        for(p1=0;p1<=p2/2;p1++){
            
            a=s[p2-p1];
            s[p2-p1]=s[p1];
            s[p1]=a;
        }
    }
}