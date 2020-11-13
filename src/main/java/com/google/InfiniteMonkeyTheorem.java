package com.google;

import java.util.ArrayList;
import java.util.List;

public class InfiniteMonkeyTheorem {

    public static void main(String[] args) {

        String input1 = "3141592653589793238462643383279";
        String[] input2 = {"314", "49", "9001", "15926535897", "14", "9323", "8462643383279", "4", "793"};

        class NumberCheck {
            String item;

            int index = 0;

            boolean flag = true;

            public NumberCheck(String item) {
                this.item = item;
            }

            public void check(char chr) {
                if (flag) {
                    if (item.charAt(index) != chr) {
                        flag = false;
                    }
                    index++;
                }
            }
        }

        List<NumberCheck> numberChecks = new ArrayList<>();
        for (int i = 0; i < input2.length; i++) {
            numberChecks.add(new NumberCheck(input2[i]));
        }

        for (int i = 0; i < input1.length(); i++) {
            for (int j = 0; j < numberChecks.size(); j++) {
                NumberCheck numberCheck = numberChecks.get(0);
                numberCheck.check(input1.charAt(i));
            }
        }

        for (int i = 0; i < input2.length; i++) {
            NumberCheck numberCheck = numberChecks.get(i);
            if (numberCheck.flag) {
                System.out.print(numberCheck.item + " ");
            }
        }

    }

}
