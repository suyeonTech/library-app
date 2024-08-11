package com.group.libraryapp.domain.book;

import javax.persistence.*;

@Entity
public class Loan {
    protected Loan() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private String user = null;

    @Column(nullable = false)
    private String book = null;



    public Loan(String user, String book) {
        if (user == null || user.isBlank()) {
            throw new IllegalArgumentException

                    (String.format("잘못된 user(%s)이 들어왔습니다.", user));
        }
        if (book == null || book.isBlank()) {
            throw new IllegalArgumentException

                    (String.format("잘못된 book(%s)이 들어왔습니다.", book));
        }
        this.user = user;
        this.book = book;
    }
}
