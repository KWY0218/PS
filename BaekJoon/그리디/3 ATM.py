import sys

def main():
    N = int(sys.stdin.readline())
    nums = list(map(int,sys.stdin.readline().split()))
    nums.sort(reverse=True)
    answer = []
    count = 0
    while nums:
        count += nums.pop()
        answer.append(count)
    print(sum(answer))
main()