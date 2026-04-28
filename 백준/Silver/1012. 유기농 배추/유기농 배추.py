import sys

sys.setrecursionlimit(100000)

def dfs(r, c, g):
    loc[r][c] = g
    for d in range(4):
        nr = r + dr[d]
        nc = c + dc[d]
        if not check(nr, nc):
            continue
        if loc[nr][nc] == 1:
            dfs(nr, nc, g)

def check(r, c):
    return 0 <= r < N and 0 <= c < M

data = sys.stdin.read().split()
idx = 0

dr = [-1, 0, 1, 0]
dc = [ 0, 1, 0, -1]

T = int(data[idx]); idx += 1

for _ in range(T):
    M = int(data[idx]); idx += 1
    N = int(data[idx]); idx += 1
    K = int(data[idx]); idx += 1

    loc = [[0] * M for _ in range(N)]

    for _ in range(K):
        c = int(data[idx]); idx += 1
        r = int(data[idx]); idx += 1
        loc[r][c] = 1

    group = 0
    for i in range(N):
        for j in range(M):
            if loc[i][j] == 1:
                group += 1
                dfs(i, j, group + 1)

    print(group)