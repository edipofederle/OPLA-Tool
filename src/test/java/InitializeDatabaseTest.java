import com.ufpr.br.opla.exceptions.MissingConfigurationException;
import com.ufpr.br.opla.results.Database;
import java.io.File;
import java.sql.Statement;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elf
 */
public class InitializeDatabaseTest {
    
    private static final String PATH_TO_DATABASE = "src/test/resources/opla.db";
    private Database db;
    
    @Before
    public void setUp(){
         db = new Database(PATH_TO_DATABASE);
    }
    
    @After
    public void cleanUp(){
        File dbfile = new File(PATH_TO_DATABASE);
        dbfile.delete();
    }
    
    @Test(expected=MissingConfigurationException.class)
    public void shouldExceptionWhenDontHavePathToDatabaseFile() throws  Exception{
        Database db = new Database("");
        db.getConnection();
    }
    
    @Test
    public void shouldCreateDBOnlyOnce() throws Exception{
        db.getConnection();
        
        File dbfile = new File(PATH_TO_DATABASE);
        
        assertTrue(dbfile.exists());
        long timestamp = dbfile.lastModified();
        
        File db2 = new File(PATH_TO_DATABASE);
        
        db.getConnection();
        assertTrue(timestamp == db2.lastModified() );
    }
    
    @Test
    public void shouldReturnStatement() throws Exception{
        Statement st = db.getConnection();
        
        assertNotNull(st);
    }
    
}
