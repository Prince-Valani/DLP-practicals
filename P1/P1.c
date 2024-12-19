#include <stdio.h>
#include <string.h>

int isValid(char str[]);

int main()
{
    char str[100];
    printf("Enter your string : ");
    scanf("%99s", str);

    if (isValid(str) == 1)
    {
        printf("Your string %s is valid", str);
    }
    else
    {
        printf("Your string %s is invalid", str);
    }
}

int isValid(char str[])
{
    if (strlen(str) < 2)
    {
        return 0;
    }

    if (strlen(str) == 2)
    {
        if (str[0] == 'b' && str[1] == 'b')
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    int i = 0;
    for (; i < strlen(str) - 2; i++)
    {
        if (str[i] != 'a') {
            return 0;
        }
    }

    if (str[strlen(str) - 2] == 'b' && str[strlen(str) - 1] == 'b') {
        return 1;
    }

    return 0;
}