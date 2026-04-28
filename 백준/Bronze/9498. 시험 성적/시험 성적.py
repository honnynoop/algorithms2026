if __name__ == '__main__':
    A = int(input())
    if A >= 90:
        print('A')
    elif 80 <= A < 90:
        print('B')
    elif 70 <= A < 80:
        print('C')
    elif 60 <= A < 70:
        print('D')
    else:
        print('F')