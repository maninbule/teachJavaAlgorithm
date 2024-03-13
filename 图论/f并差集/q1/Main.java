package f并差集.q1;

import java.util.Scanner;

/*
* P3367 【模板】并查集
* https://www.luogu.com.cn/problem/P3367
* */
public class Main {
    static int n,m;
    static int[] fa;
    static int find(int x){
        if(x == fa[x]) return x;
        else{
           fa[x] = find(fa[x]);
           return fa[x];
        }
    }
    static void join(int x,int y){
        int fx = find(x),fy = find(y);
        if(fx != fy){
            fa[fx] = fy;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        fa = new int[n + 1];
        for(int i = 1;i<=n;i++) fa[i] = i;
        for(int i = 1;i<=m;i++){
            int z = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(z == 1){
                join(x,y);
            }else{
                if(find(x) == find(y)) System.out.println("Y");
                else System.out.println("N");
            }
        }
    }
}
