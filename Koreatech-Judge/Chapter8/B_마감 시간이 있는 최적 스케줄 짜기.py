import sys

def check(profit):
    day = 1
    for d, _, _ in profit:
        if day>d: return False
        day += 1
    return True

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        N = int(sys.stdin.readline())
        nums = list(map(int,sys.stdin.readline().split()))
        works = [(nums[2*i],nums[2*i+1],i+1) for i in range(N)]
        works.sort(key=lambda x: (x[1],-x[2]))
        profit = [works.pop()]
        while works:
            temp = profit[:]
            temp.append(works.pop())
            temp.sort()
            if (check(temp)): profit[:] = temp[:]
        
        print(" ".join(str(i[2]) for i in sorted(profit, key = lambda x:x[2])))
main()

'''
    works[(deadline, profit, day), (deadline, profit, day)....]
    works.sort(key=lambda x: (x[1],-x[2]))
    마감시간이 같으면 날짜가 더 적은 순으로 정렬해야 함
'''