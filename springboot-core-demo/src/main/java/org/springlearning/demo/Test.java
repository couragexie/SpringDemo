package org.springlearning.demo;

public class Test {

    public static void main(String[] args) {
        retry:
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++){
                System.out.println(j);
                if (j == 2)
                    continue retry;
            }
        }
        System.out.println("》》》》》 ok");
    }
}
