package demo.multipledb.models.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long documentId;

    @Column(name = "name")
    private String documentName;

    @Column(name = "type")
    private String documentType;

    @Column(name = "data")
    private byte[] documentData;
}
