package com.jk.springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Junaid.Khan
 *
 */

@Getter
@Setter
@Entity
@Table(name="wikimedia_recentchange")
public class WikiMediaModel {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;
    
    @Lob
    private String   wikiEventData;

}
