import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        // given
        String sentence = "Dared to the combat; in which our valiant hamlet--\n" +
                "For so this side of our known world esteem'd him--\n" +
                "Did slay this Fortinbras; who by a seal'd compact,\n" +
                "Well ratified by law and heraldry,\n" +
                "Did forfeit, with his life, all those his lands\n" +
                "Which he stood seized of, to the conqueror:\n" +
                "Against the which, a moiety competent\n" +
                "Was gaged by our king; which had return'd\n" +
                "To the inheritance of Fortinbras,\n" +
                "Had he been vanquisher; as, by the same covenant,\n" +
                "And carriage of the article design'd,\n" +
                "His fell to HAMLET.";
        String expected = "Dared to the combat; in which our valiant Leon--\n" +
                "For so this side of our known world esteem'd him--\n" +
                "Did slay this Fortinbras; who by a seal'd compact,\n" +
                "Well ratified by law and heraldry,\n" +
                "Did forfeit, with his life, all those his lands\n" +
                "Which he stood seized of, to the conqueror:\n" +
                "Against the which, a moiety competent\n" +
                "Was gaged by our king; which had return'd\n" +
                "To the inheritance of Fortinbras,\n" +
                "Had he been vanquisher; as, by the same covenant,\n" +
                "And carriage of the article design'd,\n" +
                "His fell to Leon.";
        // when
        String actual = this.hamletParser.changeHamletToLeon(sentence);
        // then
        Assert.assertTrue(this.hamletParser.findHamlet());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        // given
        String sentence = "Thrift, thrift, Horatio! the funeral baked meats\n" +
                "Did coldly furnish forth the marriage tables.\n" +
                "Would I had met my dearest foe in heaven\n" +
                "Or ever I had seen that day, Horatio!\n" +
                "My father!--methinks I see my father.\n" +
                "HORATIO\n" +
                "Where, my lord?\n" +
                "HAMLET\n" +
                "In my mind's eye, Horatio.\n" +
                "HORATIO\n";
        String expected = "Thrift, thrift, Tariq! the funeral baked meats\n" +
                "Did coldly furnish forth the marriage tables.\n" +
                "Would I had met my dearest foe in heaven\n" +
                "Or ever I had seen that day, Tariq!\n" +
                "My father!--methinks I see my father.\n" +
                "Tariq\n" +
                "Where, my lord?\n" +
                "HAMLET\n" +
                "In my mind's eye, Tariq.\n" +
                "Tariq\n";
        // when
        String actual = this.hamletParser.changeHoratioToTariq(sentence);
        // then
        Assert.assertTrue(this.hamletParser.findHoratio());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        // given
        String sentence = "Thrift, thrift, Horatio! the funeral baked meats\n" +
                "Did coldly furnish forth the marriage tables.\n" +
                "Would I had met my dearest foe in heaven\n" +
                "Or ever I had seen that day, Horatio!\n" +
                "My father!--methinks I see my father.\n" +
                "HORATIO\n" +
                "Where, my lord?\n" +
                "HAMLET\n" +
                "In my mind's eye, Horatio.\n" +
                "HORATIO\n";
        // when
        Boolean actual = this.hamletParser.findHoratio();
        // then
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {
        // given
        String sentence = "Dared to the combat; in which our valiant hamlet--\n" +
                "For so this side of our known world esteem'd him--\n" +
                "Did slay this Fortinbras; who by a seal'd compact,\n" +
                "Well ratified by law and heraldry,\n" +
                "Did forfeit, with his life, all those his lands\n" +
                "Which he stood seized of, to the conqueror:\n" +
                "Against the which, a moiety competent\n" +
                "Was gaged by our king; which had return'd\n" +
                "To the inheritance of Fortinbras,\n" +
                "Had he been vanquisher; as, by the same covenant,\n" +
                "And carriage of the article design'd,\n" +
                "His fell to HAMLET.";
        // when
        Boolean actual = this.hamletParser.findHamlet();
        // then
        Assert.assertTrue(actual);
    }
}