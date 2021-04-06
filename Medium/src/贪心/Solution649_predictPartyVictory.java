package 贪心;

public class Solution649_predictPartyVictory {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            char c=senate.charAt(i);
            if (c=='R'){
                ints[i] = 1;
            }else {
                ints[i] = 2;
            }
        }
        int i=0;
        while (true){
            if (i==n){
                i=0;
            }
            if (ints[i]==1){
                boolean flag1=false;
                for (int j = i+1; j < n; j++) {
                    if (ints[j]==2){
                        ints[j]=0;
                        flag1=true;
                        break;
                    }
                }
                if (!flag1){
                    for (int j = 0; j < i; j++) {
                        if (ints[j]==2){
                            ints[j]=0;
                            flag1=true;
                            break;
                        }
                    }
                }
                if (!flag1){
                    return "Radiant";
                }
            }else if (ints[i]==2){
                boolean flag2=false;
                for (int j = i+1; j < n; j++) {
                    if (ints[j]==1){
                        ints[j]=0;
                        flag2=true;
                        break;
                    }
                }
                if (!flag2){
                    for (int j = 0; j < i; j++) {
                        if (ints[j]==1){
                            ints[j]=0;
                            flag2=true;
                            break;
                        }
                    }
                }
                if (!flag2){
                    return "Dire";
                }
            }
            i++;
        }
    }
}
