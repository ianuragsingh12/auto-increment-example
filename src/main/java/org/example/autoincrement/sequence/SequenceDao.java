package org.example.autoincrement.sequence;

/**
 *
 * @author Anurag Singh
 */
public interface SequenceDao {

    public long getNextSequenceId(String key) throws SequenceException;
}
