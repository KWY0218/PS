class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        if digits=="": return []
        
        result = []
        def dfs(n,path):
            if n == len(digits):
                result.append(path)
                return
            
            for i in digit[digits[n]]:
                dfs(n+1,path+i)
        
        digit = {
            "2":["a","b","c"],
            "3":["d","e","f"],
            "4":["g","h","i"],
            "5":["j","k","l"],
            "6":["m","n","o"],
            "7":["p","q","r","s"],
            "8":["t","u","v"],
            "9":["w","x","y","z"]
            }
        
        dfs(0,"")
        return result