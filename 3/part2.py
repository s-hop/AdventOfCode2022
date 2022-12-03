common_items = []
sum_priorities = 0

with open("input.txt") as file:
    lines = [line.rstrip() for line in file]
    for i in range(0, len(lines)-1, 3):
        elf_1 = list(lines[i])
        elf_2 = list(lines[i+1])
        elf_3 = list(lines[i+2])
        common_items += list(set(elf_1).intersection(elf_2, elf_3))

for x in common_items:
    if x.islower():
        sum_priorities += (ord(x)-96)
    else:
        sum_priorities += (ord(x)-38)

print(sum_priorities)
