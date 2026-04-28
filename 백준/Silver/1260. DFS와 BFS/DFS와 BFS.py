import sys
from collections import deque

input = sys.stdin.readline

def dfs(s):
    visited_dfs[s] = 1
    print(s + 1, end=' ')
    for e in range(N):
        if loc[s][e] == 1 and visited_dfs[e] == 0:
            dfs(e)

def bfs():
    que = deque()
    que.append(V - 1)
    visited_bfs[V - 1] = 1
    print(V, end=' ')
    while que:
        s = que.popleft()
        for e in range(N):
            if loc[s][e] == 1 and visited_bfs[e] == 0:
                que.append(e)
                visited_bfs[e] = 1
                print(e + 1, end=' ')

N, M, V = map(int, input().split())

loc = [[0] * N for _ in range(N)]
visited_dfs = [0] * N
visited_bfs = [0] * N

for _ in range(M):
    s, e = map(int, input().split())
    loc[s - 1][e - 1] = 1
    loc[e - 1][s - 1] = 1

sys.setrecursionlimit(10000)

dfs(V - 1)
print()
bfs()