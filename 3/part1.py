common_items = []
sum_priorities = 0

with open("input.txt") as file:
    for line in file:
        length = len(line)
        compartment1 = list(line[:length//2])
        compartment2 = list(line[length//2:])
        common_items += (list(set(compartment1).intersection(compartment2)))

for x in common_items:
    if x.islower():
        sum_priorities += (ord(x)-96)
    else:
        sum_priorities += (ord(x)-38)

print(sum_priorities)
