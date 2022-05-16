import sys

'''
    https://puleugo.tistory.com/29
'''

def main():
    S = sys.stdin.readline().rstrip()
    s = S.split("-")
    answer = 0
    x = sum(map(int,s[0].split("+")))
    if s[0][0] == '-':
        answer -= x
    else:
        answer += x
    
    for i in s[1:]:
        x = sum(map(int,i.split("+")))
        answer -= x
    print(answer)
main()