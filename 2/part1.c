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
        printf("%d\n", score);
        while (fgets(line, 5, filePointer) != NULL)
        {
            int roundScore = 0;
            if (line[0] == 'A')
            {
                if (line[2] == 'X')
                {
                    roundScore = 4;
                }
                else if (line[2] == 'Y')
                {
                    roundScore = 8;
                }
                else
                {
                    roundScore = 3;
                }
                score += roundScore;
            }
            else if (line[0] == 'B')
            {
                if (line[2] == 'X')
                {
                    roundScore = 1;
                }
                else if (line[2] == 'Y')
                {
                    roundScore = 5;
                }
                else
                {
                    roundScore = 9;
                }
                score += roundScore;
            }
            else
            {
                if (line[2] == 'X')
                {
                    roundScore = 7;
                }
                else if (line[2] == 'Y')
                {
                    roundScore = 2;
                }
                else
                {
                    roundScore = 6;
                }
                score += roundScore;
            }
        }
        printf("%d", score);
        fclose(filePointer);
    }
    return 0;
}
