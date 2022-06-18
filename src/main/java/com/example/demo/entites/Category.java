package com.example.demo.entites;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "tbl_category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {

    @Id
    @SequenceGenerator(name = "category_id_sequence", sequenceName = "category_id_sequence")
    @GeneratedValue(generator = "category_id_sequence",strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
