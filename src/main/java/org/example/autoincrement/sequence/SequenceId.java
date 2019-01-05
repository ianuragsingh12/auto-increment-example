package org.example.autoincrement.sequence;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Anurag Singh
 */
@Data
@Document(collection = "sequence")
public class SequenceId {

    @Id
    private String id;

    private long seq;
}
