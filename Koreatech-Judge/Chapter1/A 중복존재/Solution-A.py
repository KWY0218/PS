import sys

'''
    set 자료구조는 중복을 허용안하는 성질을 이용해서
    받은 카드 문자열을 set으로 변환한 다음
    카드의 길이가 N과 같으면 false를 다르면 true를 출력한다
'''
T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N = int(sys.stdin.readline().rstrip())
    card = set(map(int,sys.stdin.readline().rstrip().split()))
    print("false") if len(card) == N else print("true")