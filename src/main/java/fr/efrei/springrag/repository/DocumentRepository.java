package fr.efrei.springrag.repository;

import fr.efrei.springrag.domain.Document;
import fr.efrei.springrag.repository.dto.DocumentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query("""
        SELECT new fr.efrei.springrag.repository.dto.DocumentDTO(d.id, d.title, d.description, d.author, d.publisher, d.publishedDate, d.contentType)
        FROM Document d
    """
    )
    List<DocumentDTO> findAllDocumentsDTO();
}
