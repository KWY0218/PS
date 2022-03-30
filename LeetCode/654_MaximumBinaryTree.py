# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
#TreeNode 반환
class Solution:
    def constructMaximumBinaryTree(self, nums: list[int]):
        if len(nums)==0: return None
        root = TreeNode(val = max(nums))
        index = nums.index(max(nums))
        
        root.left = self.constructMaximumBinaryTree(nums[:index])
        root.right = self.constructMaximumBinaryTree(nums[index+1:])
        
        return root