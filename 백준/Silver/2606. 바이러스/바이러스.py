import sys
from collections import deque

def bfs(s):
    que = deque()
    que.append(s)
    visited[s] = True
    while que:
        start = que.popleft()
        for e in lists[start]:
            if visited[e]:
                continue
            que.append(e)
            visited[e] = True

def result():
    cnt = sum(1 for i in range(N) if visited[i])
    print(cnt - 1)

data = sys.stdin.read().split()
idx = 0

N = int(data[idx]); idx += 1
M = int(data[idx]); idx += 1

lists = [[] for _ in range(N)]
visited = [False] * N

for _ in range(M):
    s = int(data[idx]) - 1; idx += 1
    e = int(data[idx]) - 1; idx += 1
    lists[s].append(e)
    lists[e].append(s)

bfs(0)
result()