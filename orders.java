package com.example.internship;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class orders {
    private String head1, head2,head3, righthead;

    public orders() {
    }

    public orders(String head1, String head2,String head3, String righthead) {
        this.head1 = head1;
        this.head2 = head2;
        this.head3=head3;
        this.righthead = righthead;
    }

    public String gethead1() {
        return head1;
    }

    public void sethead1(String name) {
        this.head1 = name;
    }

    public String getrighthead() {
        return righthead;
    }

    public void setrighthead(String righthead) {
        this.righthead = righthead;
    }

    public String gethead2() {
        return head2;
    }

    public void sethead2(String head2) {
        this.head2 = head2;
    }
    public String gethead3() {
        return head3;
    }

    public void sethead3(String name) {
        this.head3 = name;
    }
}
