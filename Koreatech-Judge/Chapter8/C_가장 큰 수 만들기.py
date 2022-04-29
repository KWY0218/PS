import sys

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        N = int(sys.stdin.readline())
        nums = list(sys.stdin.readline().rstrip().split())
        print("".join(sorted(nums, key = lambda x: x*3, reverse= True)))
main()

# x*3을 하는 이유 : 1000 이하의 값이 들어와서 3자리 수로 변경한 후 비교하겠다는 뜻이다.