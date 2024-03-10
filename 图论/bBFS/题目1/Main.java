package bBFS.题目1;

/*
* https://51nod.com/Challenge/Problem.html#problemId=2081
* bfs求最短路
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
        int x = sc.nextInt(),y = sc.nextInt();
        Queue<Integer> q = new ArrayDeque<>();
        int[] dis = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        q.add(x);
        dis[x] = 0;
        vis[x] = true;
        while(q.size() > 0){
            int cur = q.poll();
            for(int v:adj[cur]){
                if(vis[v]) continue;
                vis[v] = true;
                dis[v] = dis[cur] + 1;
                q.add(v);
            }
        }
        if(!vis[y]) System.out.println("!");
        else System.out.println(dis[y]);
    }
}
