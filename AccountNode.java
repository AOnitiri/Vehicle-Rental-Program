/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Shane Lizard
 */
public class AccountNode {
     private Account value;
    private AccountNode next;
    public AccountNode(Account acc, AccountNode next) {
    value = acc;
    this.next = next;
     }
    public Account getValue() {
    return value;
    }
    public AccountNode getNext() {
    return next;
    }
    public void setNext(AccountNode next) {
    this.next = next;
}
}
