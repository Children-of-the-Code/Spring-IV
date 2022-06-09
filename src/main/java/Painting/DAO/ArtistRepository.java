package Painting.DAO;

import Painting.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    @Query("FROM Artist")
    List<Artist> findAllArtists();

    @Query("FROM Artist where name = :name")
    Artist findArtistByName(@Param("name") String name);

    @Query("FROM Artist where artist_ID = :artist_ID")
    Artist findArtistById(@Param("artist_ID") int id);
}
