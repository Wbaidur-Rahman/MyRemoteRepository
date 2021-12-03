#include<stdio.h>
int main()
{
    int aa;
    scanf("%d",&aa);
    char c;
    scanf(" %c",c);
    printf("%d\t%c",aa,c);
    char ar[100];
    gets(ar);
    int arr[100]={0};
    gets(ar);
    for(int i=0;ar[i]!='\0';i++)
        arr[ar[i]]++;
    for(int j=60;j<100;j++)
        if(arr[j]!=0) printf("%C = %d\t",j,arr[j]);
        printf("Life is beautiful");
        printf("Life is beautiful");
        printf("Life is beautiful");
        printf("Praise be to Allah");
    return 0;
}
