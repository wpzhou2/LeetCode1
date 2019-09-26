package LeetCode;

import java.util.Stack;

/**
 * @Author: weipeng
 * @Date: 2019/5/27  13:14
 * @Description:
 **/
public class LC_115_MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> stackMin;

    public LC_115_MinStack() {
        stack = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);

        if (stackMin.isEmpty()) {
            stackMin.push(x);
        } else {
            //��¼״̬
            if (stackMin.peek() < x) { //�����ʱ��ջ���� ��
                stackMin.push(stackMin.peek());
            } else {
                stackMin.push(x);
            }
        }
    }

    public void pop() {
        if (!stack.isEmpty() && !stackMin.isEmpty()) {
            stack.pop();
            stackMin.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        if (!stackMin.isEmpty()) {
            return stackMin.peek();
        }
        return -1;
    }
}
