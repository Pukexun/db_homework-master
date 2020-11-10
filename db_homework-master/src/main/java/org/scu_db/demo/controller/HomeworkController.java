package org.scu_db.demo.controller;

import org.scu_db.demo.model.Book;
import org.scu_db.demo.model.Member;
import org.scu_db.demo.model.Title;
import org.scu_db.demo.service.BookService;
import org.scu_db.demo.service.MemberService;
import org.scu_db.demo.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    private TitleService titleService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private BookService bookService;


    @RequestMapping("/1")
    public List<Integer> homework1(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询所有被借走图书的Book_ID。(对应第2题)
        //------------在此之下写下执行代码--------------
        List<Integer> bookId = new ArrayList<>();
        List<Book> book;
        book = bookService.findAllBooks();
        for (Book b : book){
            if (b.getBorrowermemno()!= null){
                bookId.add(b.getBookId());
            }
        }
        //-----------在此之上写下执行代码---------------
        return bookId;//TODO:修改返回值为bookId
    }

    @RequestMapping("/2")
    public List<Title> homework2(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询书名为”Iliad”或”Odyssey”的书目信息。(对应第4题)
        List<Title> titles = new ArrayList<>();
        //------------在此之下写下执行代码--------------
        List<Title> book;
        book = titleService.findAllTitles();
        for (Title b : book){
            if (b.getName().equals("Iliad")||b.getName().equals("Odyssey")){
                titles.add(b);
            }
        }
        //-----------在此之上写下执行代码---------------
        return titles;//TODO:修改返回值为titles
    }


    @RequestMapping("/3")
    public Integer homework3(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询callnumber为”Call123”的图书有多少本。(对应第5题)
        Integer count=0;
        //------------在此之下写下执行代码--------------
        List<Book> book;
        book = bookService.findAllBooks();
        for (Book b : book){
            if (b.getCallnumber().equals("Call123")){
                count++;
            }
        }
        //-----------在此之上写下执行代码---------------
        return count;//TODO:修改返回值为books
    }

    @RequestMapping("/4")
    public List<String> homework4(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询本数不超过2本的图书的callnumber号。(对应第7题)
        List<String> callnumbers;
        callnumbers = bookService.findBookByNum();
        //-----------在此之上写下执行代码---------------
        return callnumbers;//TODO:修改返回值为books
    }


}
