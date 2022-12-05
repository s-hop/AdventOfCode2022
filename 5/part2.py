crates = []


def main():
    with open("input.txt") as file:
        for line in file:
            # Select only lines that include crates
            if line.find("[") != -1:
                extractCrates(line)

            # Select only lines that include commands
            if line.startswith("move"):
                commands = extractCommands(line)
                num_to_move = commands[0]
                source = crates[commands[1]-1]
                destination = crates[commands[2]-1]
                block_to_move = source[-num_to_move:]

                # Move crates
                # Add block of crates to to destination stack
                crates[commands[2]-1] = destination + block_to_move
                # Remove block size from source stack
                crates[commands[1]-1] = source[:-num_to_move]
    # Print list of the top crate on each stack
    print([stack.pop() for stack in crates if type(stack) == list])


def extractCrates(line):
    num_of_stacks = (len(line)+1)//4
    for i in range(num_of_stacks):
        # add empty stacks to crates list
        if len(crates) < num_of_stacks:
            crates.append([])
    for index, char in enumerate(line, 0):
        if char.isalpha():
            # adds crate to the bottom of its respective stack
            crates[(index+1)//4].insert(0, char)


def extractCommands(line):
    commands = ([int(s) for s in line.split() if s.isdigit()])
    return commands


main()
