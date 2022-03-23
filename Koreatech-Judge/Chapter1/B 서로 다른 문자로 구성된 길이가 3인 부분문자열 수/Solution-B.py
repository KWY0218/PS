import sys

'''
    set 자료구조는 중복을 허용안하는 성질을 이용해서
    첫 요소부터 3개씩 set으로 변환한 후
    변환한 길이가 3이면 answer을 1 증가한다.
'''
def Solution(S:list) -> int:
    answer = 0
    if len(S)<3: return answer
    for i in range(len(S)-2):
        if len(set(S[i:i+3])) == 3: answer += 1
    return answer

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    S = list(sys.stdin.readline().rstrip())
    print(Solution(S))