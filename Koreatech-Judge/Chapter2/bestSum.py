import sys

def best_sum(m, nums):
    if m<0: return None
    if m == 0: return []
    best_list = None
    for n in nums:
        sum_list = best_sum(m-n,nums)
        if sum_list is not None:
            if best_list is None or len(best_list)>len(sum_list)+1:
                sum_list.append(n)
                best_list = sum_list
    return best_list

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    M, C = map(int,sys.stdin.readline().rstrip().split())
    N = list(map(int,sys.stdin.readline().rstrip().split()))
    answer = best_sum(M,N)
    if answer is not None:
        print(len(answer), " ".join(str(i) for i in answer))
    else: print(-1)
        
  
'''
    빈개수의 합 = 3의 배수
'''