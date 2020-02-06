package com.example.springrestapi.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@Table(name = "book")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Book implements Serializable {

    private static final long serialVersionUID = 12345678L;

    @Schema(description = "Unique identifier of the Book.",
            example = "1", required = true)
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;

    @Schema(description = "Title of the book",
            example = "The long road to understanding swagger", required = true)
    @NotBlank
    @Size(min = 0, max = 20)
    private String title;

    @Schema(description = "Author of the book",
            example = "Brandon Sanderson", required = true)
    @NotBlank
    @Size(min = 0, max = 30)
    private String author;
}
