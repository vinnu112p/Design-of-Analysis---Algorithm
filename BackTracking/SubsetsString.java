class SubsetsString{

public static void Subset(String str, String ans, int idx){
    if(idx == str.length()){
        System.out.println(ans);
        return;
    }

    Subset(str, ans+ str.charAt(idx), idx+1);
    Subset(str, ans, idx+1);
}

    public static void main(String[] args) {
        String str = "abc";
        Subset(str, "", 0);

    }
}