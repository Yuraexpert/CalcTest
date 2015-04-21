package com.example.yura.calctest;

import java.util.Stack;

public class Notation {
    Stack<String> A = new Stack<String>();

    public void setFunc(String s) {
        if (s == null || s.isEmpty())
            return;

        s += "#";
        A.clear();
        Stack<String> B = new Stack<String>();

        for (int i = 0; i < s.length(); i++) {
            String el = s.charAt(i)+"";

            if (el.equals("X")) {
                A.push(el);
            }
            else if (el.equals("P")) {
                A.push(String.valueOf(Math.PI));
            }

            if(isDigit(el)) {
                String num = "";
                while (isDigit(s.charAt(i)+"")) {
                    num += s.charAt(i)+"";
                    i++;
                }
                A.push(num);
                i--;
            }

            if (isOper(el)) {
                while (B.size()>0 && Priority(B.peek()) > Priority(el)) {
                    A.push(B.pop());
                }
                B.push(el);
            }

            if (el.equals("("))
                B.push("(");

            if (el.equals(")")) {
                while (B.size()>0 && !B.peek().equals("(")) {
                    A.push(B.pop());
                }
                B.pop();
            }
        }
        while (B.size() > 0)
            A.push(B.pop());
    }

    public double calc(double x) {
        Stack<Double> B = new Stack<Double>();
        for (int i = 0; i < A.size(); i++) {
            String el = A.get(i);

            if (el.equals("X"))
                B.push(x);

            if (isDigit(el.charAt(0) + "")) {
                try
                {
                    B.push(Double.valueOf(el));
                } catch (Exception e) {
                    B.push((double) 0);
                }
            }

            if (isOper(el)) {
                double arg2 = 0;
                double arg1 = 0;
                if (el.equals("s") || el.equals("c") || el.equals("t") || el.equals("n")) {
                    arg1 = B.pop();
                } else {
                    arg2 = B.pop();
                    arg1 = B.pop();
                }
                double res = 0;

                try {
                    if (el.equals("+")) res = arg2 + arg1;
                    if (el.equals("-")) res = arg1 - arg2;
                    if (el.equals("*")) res = arg1 * arg2;
                    if (el.equals("/")) if(arg2!=0)  { res = arg1 / arg2; };
                    if (el.equals("^")) res = Math.pow(arg1, arg2);
                    if (el.equals("s")) res = Math.sin(arg1);
                    if (el.equals("c")) res = Math.cos(arg1);
                    if (el.equals("t")) res = Math.tan(arg1);
                    if (el.equals("n")) res = 1/Math.tan(arg1);
                } catch (Exception e) {}
                B.push(res);
            }
        }
        return B.peek();
    }

    private boolean isDigit(String el) {
        if(Character.isDigit(el.charAt(0)) || el.equals(".")) {
            return true;
        }
        return false;
    }

    private boolean isOper(String el) {
        if (el.equals("+") ||
                el.equals("-") ||
                el.equals("*") ||
                el.equals("/") ||
                el.equals("^") ||
                el.equals("s") ||
                el.equals("c") ||
                el.equals("t") ||
                el.equals("n") )
        {
            return true;
        }
        return false;

    }

    private int Priority(String el) {
        if (el.equals("+") || el.equals("-")) return 1;
        if (el.equals("*") || el.equals("/")) return 2;
        if (el.equals("^")) return 3;
        if (el.equals("s") || el.equals("c") || el.equals("t") || el.equals("n")) return 4;
        return 0;
    }
}

