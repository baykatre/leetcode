package src.main.co.anilozturk;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(3, new ListNode(1, new ListNode(3)))));
    }

    static boolean isPalindrome(ListNode node) {

        if (Objects.isNull(node.next)) {
            return true;
        }

        ListNode input = node;
        List<Integer> integerList = new ArrayList<>();
        integerList.add(input.val);

        while (Objects.nonNull(input.next)) {
            input = input.next;
            integerList.add(input.val);
        }

        for (int i = 0; i < integerList.size() / 2; i++) {

            if (integerList.get(i) != integerList.get(integerList.size() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
