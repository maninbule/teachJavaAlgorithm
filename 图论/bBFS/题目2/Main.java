package bBFS.题目2;

/*
* https://www.51nod.com/Challenge/Problem.html#problemId=2600
* bfs求所有点的最短路
* */

import java.util.*;
public class Main {
    static ArrayList<Integer> []adj = new ArrayList[1010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),m = sc.nextInt();
        for(int i = 1;i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 1;i<=m;i++){
            int x = sc.nextInt(),y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        Queue<Integer> q = new ArrayDeque<>();
        int[] dis = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        q.add(1);
        dis[1] = 0;
        vis[1] = true;
        while(q.size() > 0){
            int cur = q.poll();
            for(int v:adj[cur]){
                if(vis[v]) continue;
                vis[v] = true;
                dis[v] = dis[cur] + 1;
                q.add(v);
            }
        }
        for(int i = 2;i<=n;i++){
            int ans = -1;
            if(vis[i]) ans = dis[i];
            System.out.println(ans);
        }
    }
}
