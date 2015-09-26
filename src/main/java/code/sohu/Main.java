package code.sohu;

import java.util.Scanner;

/**
 * Created by yonney on 2015/9/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        boolean[] people = new boolean[2 * n];
        solution(people, n, k);
        for (int i = 0; i < people.length; i++) {
            System.out.print(people[i] == false ? 1 : 0);
        }
    }

    public static void solution(boolean[] people, int n, int k) {
        int num = 0;
        int count = 0;
        int index = 0;

        while (num < n) {
            if (!people[index]) {
                count++;
                if (count == k) {
                    count = 0;
                    people[index] = true;
                    num++;
                }
            }
            index++;
            if (index == people.length) {
                index = 0;
            }
        }
    }
}
