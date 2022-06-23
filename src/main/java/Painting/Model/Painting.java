package Painting.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Painting {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int painting_ID;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private int year;
    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "artist")
    Artist artist;

}
