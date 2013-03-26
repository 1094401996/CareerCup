//Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including the null character.)
void reverse (char *pt){
    char *end = pt;
    char temp;
    while(true){
        if (*end == null)
        break;
        end++;
    }
    --end;
    while(pt<end){
        temp = *pt;
        *pt++ = *end;
        *end-- = temp;
    }
}
