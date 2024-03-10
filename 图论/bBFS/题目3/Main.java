package bBFS.题目3;

import java.util.*;
/*
* https://www.luogu.com.cn/problem/P2853
* bfs + 枚举
* */
public class Main {
    static ArrayList<Integer>[] adj = new ArrayList[1010];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(),n = sc.nextInt(),m = sc.nextInt();
        for(int i = 1;i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        int[] pos = new int[k];
        int[] cnt = new int[n + 1];
        for(int i = 0;i<k;i++){
            pos[i] = sc.nextInt();
        }
        for(int i = 1;i<=m;i++){
            int x = sc.nextInt(),y = sc.nextInt();
            adj[x].add(y);
        }
        for(int i = 0;i<k;i++){
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] vis = new boolean[n + 1];
            q.add(pos[i]);
            vis[pos[i]] = true;
            cnt[pos[i]] += 1;
            while(!q.isEmpty()){
                int u = q.poll();
                for(int v:adj[u]){
                    if(vis[v]) continue;
                    vis[v] = true;
                    cnt[v] += 1;
                    q.add(v);
                }
            }
        }
        int ans = 0;
        for(int i = 1;i<=n;i++){
            if(cnt[i] == k) ans++;
        }
        System.out.println(ans);
    }
}

/*
2 4 4
2
3
1 2
1 4
2 3
3 4
* */