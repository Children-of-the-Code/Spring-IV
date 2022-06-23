package Painting.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Artist {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artist_ID;
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "artist")
    @JsonIgnoreProperties(value = {"artist"})
    List<Painting> paintings;

}
