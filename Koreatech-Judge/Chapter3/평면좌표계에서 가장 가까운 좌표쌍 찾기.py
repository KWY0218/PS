import sys
import math

def distance(p1,p2):
    dx = abs(p1[0]-p2[0])
    dy = abs(p1[1]-p2[1])
    return math.sqrt(dx**2+dy**2)

def find_min_distance(px):
    temp = float("inf")
    for i in range(len(px)-1):
        for j in range(i+1,len(px)):
            temp = min(temp,distance(px[i],px[j]))
    return temp

def solution(site):
    px = sorted(site, key = lambda x: x[0])
    py = sorted(site, key = lambda x: x[1])
    return closet_pair(px,py)

def closet_pair(px,py):
    if len(px)<=3:
        return find_min_distance(px)
    
    mid = len(px)//2
    lx, rx = px[:mid], px[mid:]
    ly, ry = [p for p in py if p[0]<px[mid][0]], [p for p in py if p[0]>=px[mid][0]]
    
    delta = min(closet_pair(lx,ly),closet_pair(rx,ry))
    return closet_split_pair(px,py,delta)
    
def closet_split_pair(px,py,delta):
    mid = len(px)//2
    mid_x = px[mid][0]

    sites = []
    for p in py:
        if abs(p[0] - mid_x) < delta: 
            sites.append(p)

    for i in range(len(sites) - 1):
        for j in range(i + 1, min(i + 8, len(sites))):
            dist = distance(sites[i], sites[j])
            delta = min(delta, dist)
    return delta

T = int(sys.stdin.readline())
for _ in range(T):
    N = int(sys.stdin.readline())
    nums = list(map(int,sys.stdin.readline().split()))
    nums = [(nums[2*i],nums[2*i+1]) for i in range(N)]
    print(f'{solution(nums):.2f}')