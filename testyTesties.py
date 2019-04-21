from functional import *

print(flatten([ [1, 2, [3, 4] ], [5, 6], 7]))
print(reverse([[1, 2], [3, [4, 5]], 6]))
print(compress([1, 1, 4]))
print(flatten([]))
print(reverse([]))
print(compress([]))

print(capitalized(["derp", "Yurp", "smurf"]))
print(capitalized([]))
print(longest(["yuerb", "woefnon", "woi", ""]))
print(longest(["duh", "i wef f oweinf iwon", "oh noey"]))

h = composition(lambda x: capitalized(x), lambda y: longest(y))
print(h(["derp", "Yurp", "smurf"]))

h2 = n_composition(lambda x: reverse(x), lambda y: capitalized(y), lambda z: longest(z))
print(h(["derp", "Yurp", "smurf"]))