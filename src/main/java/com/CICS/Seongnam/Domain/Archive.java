package com.CICS.Seongnam.Domain;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.*;
import javax.persistence.*;

@Getter
@Setter
@Entity(name = "archive")
@Indexed
public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "archive_no")
    private Integer archiveNo;

    @Column(name = "title")
    @Field
    private String title;

    @Column(name = "content")
    @Field
    private String content;

    @Column(name = "background")
    @Field
    private String background;
}
