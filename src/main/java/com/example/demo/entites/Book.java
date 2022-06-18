package com.example.demo.entites;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@Entity
@Table(name = "tbl_book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    @Id
    @SequenceGenerator(name = "book_id_sequence", sequenceName = "book_id_sequence")
    @GeneratedValue(generator = "book_id_sequence", strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "no_of_page")
    private Integer numberOfPage;

    @Column(name = "isbn_number", length = 30)
    private String isbnNumber;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "stock_count")
    private Integer stockCount;

    @Column(name = "publish_date")
    private Date publishedDate;

    @Column(name = "cover_photo_path")
    private String coverPhotoPath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",  foreignKey = @ForeignKey(name = "FK_BOOK_CATEGORY"))
    private Category category;

    @ManyToMany
    @JoinTable(name = "book_author_mapping")
    private List<Author> authorList;
}
