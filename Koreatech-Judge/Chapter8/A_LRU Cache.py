import sys

# https://haningya.tistory.com/110

class Node:
    def __init__(self,K = 0, V = 0) -> None:
        self.key, self.value = K, V
        self.next = None
        self.prev = None

class LRUCache:
    def __init__(self,C) -> None:
        self.capacity = C
        self.size = 0
        self.cache = dict()
        self.head_key = Node()
        self.tail_key = Node()
        self.head_key.next = self.tail_key
        self.tail_key.prev = self.head_key
    
    def put(self,K, V):
        temp:Node = self.cache.get(K)
        if temp is None:
            new_node = Node(K,V)
            self.cache[K] = new_node
            self.add(new_node)
            self.size += 1
        else:
            temp.value = V
            self.update(temp)
        
        if self.size>self.capacity:
            del_node:Node = self.tail_key.prev
            self.remove(del_node)
            self.cache.pop(del_node.key)
            self.size -= 1
    
    def get(self,K) -> int:
        temp:Node = self.cache.get(K)
        if temp is None: return -1
        self.update(temp)
        return temp.value
    
    def update(self,node:Node):
        self.remove(node)
        self.add(node)
    
    def add(self,node:Node):
        next_node:Node = self.head_key.next
        self.head_key.next = node
        node.prev = self.head_key
        node.next = next_node
        next_node.prev = node
    
    def remove(self,node:Node):
        before_node: Node = node.prev
        next_node: Node = node.next
        before_node.next = next_node
        next_node.prev = before_node

def main():
    T = int(sys.stdin.readline())
    for _ in range(T):
        C, N = map(int,sys.stdin.readline().split())
        cache = LRUCache(C)
        nums = list(map(int,sys.stdin.readline().split()))
        index = 0
        while index<len(nums):
            if nums[index] == 0:
                cache.put(nums[index+1],nums[index+2])
                index += 3
            else:
                print(cache.get(nums[index+1]), end=" ")
                index += 2
    print()
main()