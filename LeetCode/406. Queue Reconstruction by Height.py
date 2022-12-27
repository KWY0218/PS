import heapq
def reconstructQueue(people: list[list[int]]) -> list[list[int]]:
    peoples = sorted(people,key=lambda x: (x[0],-x[1]),reverse=True)
    print(peoples)
    result = []
    for p_h, p_k in peoples:
        result.insert(p_k,[p_h,p_k])
        print(result)
    return result

reconstructQueue([[9,0],[7,0],[1,9],[3,0],[2,7],[5,3],[6,0],[3,4],[6,2],[5,2]])