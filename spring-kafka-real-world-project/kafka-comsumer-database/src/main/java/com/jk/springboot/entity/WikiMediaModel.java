package com.jk.springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="wikimedia_recentchange")
@Getter
@Setter
public class WikiMediaModel {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;


    @Lob
    private String   wikiEventData;

}
