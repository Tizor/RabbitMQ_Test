package app.repository;

import app.entity.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface NoteRepo extends CrudRepository<Note, Long> {

    @Query("select child from Note child where child.userNote.customerNumber = :number")
    Collection<Note> getChildNotes(@Param("number") Long number);
}
