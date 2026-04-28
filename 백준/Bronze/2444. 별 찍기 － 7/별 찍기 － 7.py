def abs(n):
    if n>0: return n
    else : return -n


if __name__ == '__main__':
    M = int(input())
    N=2*M-1
    for i in range(N):
        for j in range(abs(i-N//2)):
            print('',end=' ')
        for j in range(N-2*(abs(i-N//2))):
            print('*',end='')
        print()