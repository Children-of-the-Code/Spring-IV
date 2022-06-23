package Painting.DAO;

import Painting.Model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaintingRepository extends JpaRepository<Painting, Integer> {
}
