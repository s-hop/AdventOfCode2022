#include <stdio.h>
#include <time.h>

int main(void)
{
    FILE *filePointer;
    char line[5];
    int score = 0;

    filePointer = fopen("input.txt", "r");

    if (filePointer == NULL)
    {
        printf("File failed to open.");
    }
    else
    {
        while (fgets(line, 5, filePointer) != NULL)
        {
            if (line[0] == 'A')
            {
                if (line[2] == 'X')
                {
                    score += 3 + 0;
                }
                else if (line[2] == 'Y')
                {
                    score += 1 + 3;
                }
                else
                {
                    score += 2 + 6;
                }
            }
            else if (line[0] == 'B')
            {
                if (line[2] == 'X')
                {
                    score += 1 + 0;
                }
                else if (line[2] == 'Y')
                {
                    score += 2 + 3;
                }
                else
                {
                    score += 3 + 6;
                }
            }
            else
            {
                if (line[2] == 'X')
                {
                    score += 2 + 0;
                }
                else if (line[2] == 'Y')
                {
                    score += 3 + 3;
                }
                else
                {
                    score += 1 + 6;
                }
            }
        }
        printf("%d", score);
        fclose(filePointer);
    }
    return 0;
}
