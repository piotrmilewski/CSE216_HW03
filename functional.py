def flatten(fList:list) -> list:
    if fList == []:
        return fList
    if isinstance(fList[0], list):
        return flatten(fList[0]) + flatten(fList[1:])
    return fList[:1] + flatten(fList[1:])

def reverse(rList:list) -> list:
    if rList == []:
        return rList
    if isinstance(rList[0], list):
        return reverse(rList[1:]) + [reverse(rList[0])]
    return reverse(rList[1:]) + rList[:1]

def compressHelper(cList:list, newList:list, index:int) -> list:
    if len(cList) == index:
        return newList
    elif newList.count(cList[index]) == 1:
        return compressHelper(cList, newList, index+1)
    else:
        newList.append(cList[index])
        return compressHelper(cList, newList, index+1)

def compress(cList:list) -> list:
    return compressHelper(cList, [], 0)

print(flatten([ [1, 2, [3, 4] ], [5, 6], 7]))
print(reverse([[1, 2], [3, [4, 5]], 6]))
print(compress([1, 1, 4]))
print(flatten([]))
print(reverse([]))
print(compress([]))