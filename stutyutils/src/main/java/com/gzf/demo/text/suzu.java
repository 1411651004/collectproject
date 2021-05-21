package com.gzf.demo.text;

        import java.util.Scanner;

public class suzu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 3;
        int n1 = 100;
        int[] nnn = new int[n1];
        int[][] a = new int[n][n];
        int zong = 0;
        while (!scanner.hasNextInt()){
            nnn[zong] = scanner.nextInt();
            zong++;

        }
        System.out.println(zong);
        for (int j = 0;j<n;j++) {
            for (int i = 0; i < n; i++) {
                a[j][i] = scanner.nextInt();
            }
        }
        //int[][] asd = new int[][]{{1,4,7},{2,5,8},{3,6,9}};
        int[][] result = change(a);
        for (int j = 0;j<3;j++){
            for (int i = 0;i<3; i++){
                System.out.print(result[j][i]+"\t");
            }
            System.out.println();
        }
    }
    public static int[][] change(int [][]matrix){
        int [][]temp=new int[matrix[0].length][matrix.length];
        int dst=matrix.length-1;
        for(int i=0;i<matrix.length;i++,dst--){
            for(int j=0;j<matrix[0].length;j++){
                temp[j][dst]=matrix[i][j];
            }
        }
        return temp;
    }
}
