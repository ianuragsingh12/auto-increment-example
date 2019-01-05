package org.example.autoincrement.count;

import lombok.Data;
import org.example.autoincrement.sequence.SequenceDao;
import org.example.autoincrement.sequence.SequenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Create the “sequence” collection in your MongoDB first! 
 * use sequence_test_db
 * db.sequence.insert({_id: "counting",seq: 0})
 *
 * @author Anurag Singh
 */
@Service
public class Test {

    private static final String HOSTING_SEQ_KEY = "counting";

    @Autowired
    private SequenceDao sequenceDao;

    @Autowired
    private DAO countingDao;

    public void save(String name) throws SequenceException {

        Model counting = new Model();

        counting.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
        counting.setName(name);
        countingDao.save(counting);

        System.out.println(counting);

    }
}

@Data
@Document(collection = "counting")
class Model {

    @Id
    private long id;

    private String name;
}

@Repository
class DAO {

    @Autowired
    private MongoOperations mongoOperation;

    public void save(Model counting) {
        mongoOperation.save(counting);
    }
}
