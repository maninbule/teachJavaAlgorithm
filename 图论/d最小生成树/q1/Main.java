package d最小生成树.q1;

import java.util.ArrayList;
import java.util.Scanner;

/*
* https://www.luogu.com.cn/problem/P3366
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
        ArrayList<int[]> arr = new ArrayList<>();
        fa = new int[n + 1];
        for(int i = 1;i<=n;i++) fa[i] = i;
        for(int i = 1;i<=m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            arr.add(new int[]{x,y,z});
        }
        arr.sort((a,b)->a[2]-b[2]);
        int ans = 0;
        int cnt = 0;
        for(int[] edge:arr){
            int x = edge[0],y = edge[1],z = edge[2];
            if(find(x) != find(y)){
                ans += z;
                cnt++;
                join(x,y);
            }
        }
        if(cnt != n-1) System.out.println("orz");
        else System.out.println(ans);
    }
}
