package Painting.Service;

import Painting.DAO.ArtistRepository;
import Painting.Model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArtistService {
    ArtistRepository artistRepository;
    @Autowired
    public ArtistService(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }
    public List<Artist> getAllArtists(){
        return artistRepository.findAllArtists();
    }
    public boolean checkArtistExistsById(int id){
        Artist a = artistRepository.findArtistById(id);
        if(a == null){
            return false;
        }
        return true;
    }
    public boolean checkArtistExistsByName(String name){
        Artist a = artistRepository.findArtistByName(name);
        if(a == null){
            return false;
        }
        return true;
    }
    public void saveArtist(Artist a){
        artistRepository.save(a);
    }
    public Artist getArtistById(int id){
        return artistRepository.findArtistById(id);
    }
    public Artist getArtistByName(String name){
        return artistRepository.findArtistByName(name);
    }

}
