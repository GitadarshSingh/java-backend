package com.cfs.BookAPI.controller;

import com.cfs.BookAPI.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    //Hashmap :Becuase we do not have any DB right now
    private Map<Long, Book> bookDB = new HashMap<>();

    private long c=1;

    //---------------------------------------------------------------------------------------

    // GET
    @GetMapping              // 'ResponseEnity' is a class where response wrapped, using response enity is a good practice
    public ResponseEntity<List<Book>> getAllBooks()
    {
        return ResponseEntity.ok(new ArrayList<>(bookDB.values()));

    }
    //jb bhi main responseentity return krunga, us time main status code(like 200,201,400,500 etc)  pass kr skta hu

    //-----------------------------------------------------------------------------------------

    // resposne entity mein data dalna hai or create karna hai . POST :

    //POST
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) //@RequestBody → HTTP request ke body (zyadatar JSON) ko Java object me convert karta hai, Jackson ki help se.
    {
        bookDB.put(book.getId(),book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);

    }

    //----------------------------------------------------------------------------------------------------

    //book return karni hai

    // GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookbyId(@PathVariable Long id)
    {
        Book book = bookDB.get(id);
        if(book == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(book);
    }

    //---------------------------------------------------------------------------------------------------

    //put: update book fully
    //PUT : fully data body ko update karta hai
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Long id,@RequestBody Book book)
    {
        Book existing = bookDB.get(id);
        if(existing==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        bookDB.put(id,book);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //200ok

    }

    //---------------------------------------------------------------------------------------------------

    //PATCH: half partial update ke liye hota hai
    @PatchMapping("/{id}/price") // es id ka sirf price update karna hai
    public ResponseEntity<Book> updatePrice(@PathVariable Long id,@RequestBody Double newPrice)
    {
        Book existing = bookDB.get(id);
        if(existing==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        existing.setPrice(newPrice);
        bookDB.put(id,existing);
        return ResponseEntity.ok(existing); //200ok

    }

    //---------------------------------------------------------------------------------------------

//    DELETE
//    Delete Mapping
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> updatePrice(@PathVariable Long id)
    {
        Book existing = bookDB.remove(id);
        if(existing==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build(); //200ok

    }


}
