package com.example.Online.bookstore.repo;

import com.example.Online.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    // חיפוש כל הספרים של סופר ספציפי
    List<Book> findByAuthor(String author);

    // חיפוש ספרים שהכותרת שלהם מכילה מילה מסוימת (מתעלם מאותיות רישיות/קטנות באנגלית)
    List<Book> findByTitleContainingIgnoreCase(String title);

    // שליפת ספרים שמחירם נמוך ממחיר מקסימלי מסוים (טוב לסינון "ספרים עד X שקלים")
    List<Book> findByPriceLessThan(Double price);

    // שליפת ספרים בטווח מחירים מסוים
    List<Book> findByPriceBetween(Double minPrice, Double maxPrice);

    // שליפת ספרים ארוכים (עם יותר מ-X עמודים)
    List<Book> findByPagesGreaterThan(Integer pages);
}