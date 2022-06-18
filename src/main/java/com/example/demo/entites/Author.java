package com.example.demo.entites;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "tbl_author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Author implements Serializable {

    @Id
    @SequenceGenerator(name = "author_id_sequence", sequenceName = "author_id_sequence")
    @GeneratedValue(generator = "author_id_sequence", strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;


}
