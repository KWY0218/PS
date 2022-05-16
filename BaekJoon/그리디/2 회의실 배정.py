import sys

'''
    시작 시간을 기준으로 먼저 정렬을 한 후
    도착 시간을 기준으로 정렬을 한다
'''
def main():
    N = int(sys.stdin.readline())
    heap = []
    for _ in range(N):
        start, end = map(int,sys.stdin.readline().split())
        heap.append((start,end))
    heap.sort(key = lambda x:x[0])
    heap.sort(key = lambda x:x[1])

    count = 1
    end_time = heap[0][1]
    for i in range(1,N):
        if heap[i][0]>=end_time:
            count += 1
            end_time = heap[i][1]
    print(count)
main()