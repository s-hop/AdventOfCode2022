# Initial crate setup
crates = [
    0,
    ["B", "Z", "T"],
    ["V", "H", "T", "D", "N"],
    ["B", "F", "M", "D"],
    ["T", "J", "G", "W", "V", "Q", "L"],
    ["W", "D", "G", "P", "V", "F", "Q", "M"],
    ["V", "Z", "Q", "G", "H", "F", "S"],
    ["Z", "S", "N", "R", "L", "T", "C", "W"],
    ["Z", "H", "W", "D", "J", "N", "R", "M"],
    ["M", "Q", "L", "F", "D", "S"]
]

# Takes crates off the top of a stack in blocks and adds to another
with open("input.txt") as file:
    for line in file:
        if line.startswith("m"):
            commands = ([int(s) for s in line.split() if s.isdigit()])
            num_to_move = commands[0]
            source = crates[commands[1]]
            destination = crates[commands[2]]
            block_to_move = source[-num_to_move:]

            # Add block of crates to to destination stack
            crates[commands[2]] = destination + block_to_move
            # Remove block size from source stack
            crates[commands[1]] = source[:-num_to_move]

# Print list of the top crate on each stack
print([stack.pop() for stack in crates if type(stack) == list])
