package bg.softuni.mobilele.model.entities;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

   // @Column(nullable = false)
   // protected Instant created;

   // @Column(nullable = false)
   // protected Instant modified;



    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

}
