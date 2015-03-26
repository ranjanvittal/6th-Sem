#include <stdio.h>
#include <dirent.h>

int main()
{
    DIR *dir;
    struct dirent *dp;
    char * file_name;
    dir = opendir(".");
    while ((dp=readdir(dir)) != NULL) {
        if ( !strcmp(dp->d_name, ".") || !strcmp(dp->d_name, "..") )
        {
            // do nothing (straight logic)
        } else {
            file_name = dp->d_name; // use it
            printf("file_name: \"%s\"\n",file_name);
        }
    }
    closedir(dir);
    return 0;
}
