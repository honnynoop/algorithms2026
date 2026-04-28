# OK - dp
N = int(input())
sugar = [9999] * (N + 10)
sugar[3] = 1
sugar[5] = 1

for i in range(6, N + 10):
    # 최소값+1  6=> 3+3 3이 두개
    sugar[i] = min(sugar[i-3], sugar[i-5]) + 1

if sugar[N] >= 9999:
    print(-1)
else:
    print(sugar[N])
# print(sugar)