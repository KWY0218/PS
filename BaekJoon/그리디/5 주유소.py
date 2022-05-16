import sys

def main():
    N = int(sys.stdin.readline())
    load = list(map(int,sys.stdin.readline().split()))
    city = list(map(int,sys.stdin.readline().split()))
    money = 0
    c = city[0]
    for i in range(N-1):
        if c>city[i]:
            c = city[i]
        money += c*load[i]
    print(money)
main()