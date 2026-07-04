class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        int count=0;
        for(int i=0;i<k;i++){
            char ch=s.charAt(i);
            if((ch=='a') || (ch=='e') || (ch=='i') || (ch=='o') || (ch=='u')){
                count++;
            }
        }
        int maxCount=count;
        for(int i=k;i<n;i++){
            char left = s.charAt(i - k);

        if (left == 'a' || left == 'e' || left == 'i'
            || left == 'o' || left == 'u') {
         count--;
        }
            char c=s.charAt(i);

            if((c=='a') || (c=='e') || (c=='i') || (c=='o') || (c=='u')){
                count++;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}