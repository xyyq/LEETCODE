import java.util.Scanner;
import java.io.BufferedReader;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.RandomAccessFile;

import java.io.Reader;
public class ByteDance01{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int N = Integer.valueOf(num);
        String str = br.readLine();
        String[] chars = str.split(" ");
        int[][] dp = new int[N][2];
        int count = 0;
        if(chars[0] == "B"){
            dp[0][0] = 1;
            dp[0][1] = 1;
            count++;
        }else{
            dp[0][0] = 0;
            dp[0][1] = 1;
        }
        for(int j = 1; j < N; j++){
            if(chars[j] == "B"){
                dp[j][0] = dp[j - 1][0] + 1;
                dp[j][1] = dp[j][0];
                count++;
            }else{
                if(canTree(j, chars)){
                    dp[j][0] = Math.max(dp[j-1][0],dp[j-1][1]);
                    dp[j][1] = dp[j-1][0] + 1;

                }else{
                    dp[j][0]  = Math.max(dp[j-1][0], dp[j-1][1]);
                    dp[j][1] =  dp[j][0];
                }
            }

        }

        System.out.println(Math.max(dp[N-1][0],dp[N-1][1]) -count );
    }
    public static boolean canTree(int j , String[] chars){
        if (chars[j-1].charAt(0) != 'Y' ){
            return false;
        }
        if (j+1 < chars.length && chars[j-1].charAt(0) != 'Y'){
            return false;
        }
        return true;
    }

}
