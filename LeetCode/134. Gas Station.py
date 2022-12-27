def findContentChildren(g: list[int], s: list[int]) -> int:
    g_index = 0
    s_index = 0
    g.sort()
    s.sort()
    answer = 0
    while g_index<len(g) and s_index<len(s):
        if g[g_index] <= s[s_index]:
            g_index += 1
            s_index += 1
            answer += 1
        else: g_index += 1
    print(answer)
    return answer

findContentChildren(g = [1,2], s = [1,2,3])