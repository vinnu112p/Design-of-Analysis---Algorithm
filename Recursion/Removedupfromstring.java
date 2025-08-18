


class Removedupfromstring {

    public static void remove(String str){
        StringBuilder sb = new StringBuilder("");
        int idx = 0;
        boolean arr[] = new boolean[26];
        while( idx < str.length()){
            int n = str.charAt(idx) - 'a';
            if(!(arr[n])){
                sb.append(str.charAt(idx));
                arr[n] = true;
            }
            idx++;
        }
        System.out.println(sb);
    }
  
    public static void main(String[] args) {
        String s = "apnacollege";
        remove(s);
        
    }
}
