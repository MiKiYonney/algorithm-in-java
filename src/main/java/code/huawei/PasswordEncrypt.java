package code.huawei;

import java.util.Scanner;

/**
 * Created by yonney on 2015/8/12.
 * 题目描述
 1、对输入的字符串进行加解密，并输出。
 2加密方法为：
 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 其他字符不做变化。
 3、解密方法为加密的逆过程。
 void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出
 int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出
 */
public class PasswordEncrypt {
    void Encrypt (char aucPassword[], char aucResult[]){
        for (int i = 0; i < aucPassword.length; i++) {
            char c = aucPassword[i];
            if((c >= '0') && (c <= '9')){
                if(c != '9'){
                    aucResult[i] = (char) (c+1);
                }else {
                    aucResult[i] = '0';
                }
            }else if((c >= 'A') && (c <= 'z')){
                if(Character.isUpperCase(c)){
                    if(c != 'Z'){
                        aucResult[i] = (char)(c+('b'-'A'));
                    }else{
                        aucResult[i] = 'a';
                    }
                }else {
                    if(c != 'z'){
                        aucResult[i] = (char)(c-('a'-'B'));
                    }else{
                        aucResult[i] = 'A';
                    }
                }
            }else{
                aucResult[i] = c;
            }
        }
    }

    int unEncrypt (char result[], char password[]){
        for (int i = 0; i < result.length; i++) {
            char c = result[i];
            if((c >= '0') && (c <= '9')){
                if(c != '0'){
                    password[i] = (char) (c-1);
                }else {
                    password[i] = '9';
                }
            }else if((c >= 'A') && (c <= 'z')){
                if(Character.isUpperCase(c)){
                    if(c != 'A'){
                        password[i] = (char)(c+('a'-'B'));
                    }else{
                        password[i] = 'z';
                    }
                }else {
                    if(c != 'a'){
                        password[i] = (char)(c-('b'-'A'));
                    }else{
                        password[i] = 'Z';
                    }
                }
            }else{
                password[i] = c;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordEncrypt p = new PasswordEncrypt();

        String input = scanner.nextLine();
        String input1 = scanner.nextLine();

        char aucPassword[] = input.toCharArray();
        char aucResult[] = new char[aucPassword.length];

        char result[] = input1.toCharArray();
        char password[] = new char[result.length];

        p.Encrypt(aucPassword, aucResult);
        p.unEncrypt(result,password);

        System.out.println(aucResult);
        System.out.println(password);

    }
}

