package core;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import core.model.Language;
import net.vz.mongodb.jackson.DBQuery;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.MongoCollection;
import net.vz.mongodb.jackson.WriteResult;
import org.bson.types.ObjectId;
import org.junit.*;

import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Date: 03/09/12
 * Time: 14:18
 */
public class ModelTest {
    protected static Mongo mongo = null;
    protected static DB db;
    protected static JacksonDBCollection<Language,  ObjectId> jacksonLangColl;

    @BeforeClass
    public static void oneTimeSetUp() {
        // one-time setup code
        try{
            mongo = new Mongo();
            mongo.dropDatabase("testdb");

            DB db = mongo.getDB( "testdb" );

            DBCollection languageColl = db.getCollection(Language.class.getAnnotation(MongoCollection.class).name());
            jacksonLangColl = JacksonDBCollection.wrap(languageColl, Language.class, ObjectId.class);
        }
        catch (UnknownHostException e1){}
        catch (MongoException e2){}
    }

    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
        if(mongo != null){
            mongo.close();
        }
    }

    @Before
    public void perTestSetUp() {
    }

    @After
    public void perTestTearDown() {
    }

    @Test
    public void testMultiply() {
        assertEquals("testing via junit", 1, 1);
    }

    @Test
    public void testLanguage(){
        Language toInsert = buildLanguage();
        WriteResult<Language, ObjectId> wrlang = jacksonLangColl.insert(toInsert);
        ObjectId savedId = wrlang.getSavedId();
        assertNotNull("language not saved", wrlang.getSavedId());

        Language l = jacksonLangColl.findOneById(savedId);
        assertEquals("read wrong language", savedId, l.getId());
        assertEquals("read wrong language", toInsert.getLanguageCode(), l.getLanguageCode());
    }

    private Language buildLanguage(){
        Language l = new Language();
        l.setLanguageCode("en");
        return l;
    }

}
