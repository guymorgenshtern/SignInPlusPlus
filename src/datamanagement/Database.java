package datamanagement;

import utilities.SinglyLinkedList;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * Abstract representation of a database
 *
 * @author Alston
 * last updated on 12/3/2018
 */
public interface Database {

    /**
     * Adds a new student to the database
     *
     * @param newStudent a new specified student
     * @return true, if the student was successfully added; false otherwise
     */
    boolean addStudent(Student newStudent);

    /**
     * Queries a student from the database by student id
     *
     * @param id a student id
     * @return the queried student, or null if no student with the specified id is found
     * @throws IOException thrown if the database fails to be properly accessed
     */
    Student findStudentById(int id) throws IOException;

    /**
     * @return a list of the students currently entered into the database
     */
    SinglyLinkedList<Student> getStudents();

    /**
     * Verifies if a student with a specified student id is currently signed in.
     * A student is currently signed if he or she has one or more unresolved sessions.
     * If no such student is found in the database, false is returned
     *
     * @param id a student id
     * @return true, if the student is found and is currently signed in; false otherwise
     * @throws IOException thrown if the database fails to be properly accessed
     */
    boolean isStudentSignedIn(int id) throws IOException;

    /**
     * Replaces a student with another student that shares the same student id.
     * If no such student is found in the database, no update is made.
     *
     * @param updatedStudent the new updated student
     * @return true, if the student was found and updated; false otherwise
     */
    boolean updateStudent(Student updatedStudent);

    /**
     * Removes a student with a specified student id from the database.
     * If no such student is found in the Database, no removal is made.
     *
     * @param id a student id
     * @return true, if the student was found and removed; false otherwise
     */
    boolean removeStudentById(int id);

    /**
     * Adds a new resolved or unresolved session to the database
     *
     * @param newSession
     * @return true, if the session was successfully added; false otherwise
     */
    boolean addSession(Session newSession);

    /**
     * Queries sessions from the database that match some specified criteria.
     *
     * @param query a Query object containing the criteria
     * @return a list of the retrieved Sessions, or an empty list of no Sessions are retrieved
     * @throws IOException thrown if the database fails to be accessed
     */
    SinglyLinkedList<Session> findSessions(Query query) throws IOException;

    /**
     * Resolves all unresolved sessions referencing a Student with the specified id.
     * A session is resolved by setting its {@link Session#endTime} from null to the time argument
     *
     * @param id   a student id
     * @param time the end time of the unresolved sessions
     * @return true, if any amount (0+) of sessions were successfully found and resolved; false otherwise
     */
    boolean resolveOpenSessions(int id, Timestamp time);

    /**
     * Closes the database by closing any opened resources
     */
    void close();

}
