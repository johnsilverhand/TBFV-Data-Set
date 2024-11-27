def IsValidBST( root,vec):
    #self.vec = []  # 清空数组
    if not root:
        return True
    
    for i in range(1, len(vec)):
        # 注意要小于等于，搜索树里不能有相同元素
        if vec[i] < vec[i - 1]: #wrong code
            return False
    return True
if __name__ == "__main__":
    root = [2,1,3]
    vec = [2,1,3]
    print(IsValidBST(root,vec))