from functools import reduce

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

def capitalized(items:list) -> list:
    return list(map(lambda x: x.capitalize(), items))

def longest(strings:list, from_start=True) -> object:
    return reduce((lambda x, y: x if len(x) > len(y) else (y if len(x) < len(y) else (x if from_start else y))), strings)

def composition(f, g):
    return lambda *args, **kwargs: g(f(*args, **kwargs)) # calls f then g

def n_composition(*functions):
    return reduce(composition, functions) # repeatedly applies composition to functions