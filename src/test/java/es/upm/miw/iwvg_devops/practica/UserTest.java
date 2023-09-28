package es.upm.miw.iwvg_devops.practica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;
    private ArrayList<Fraction> fractions;
    @BeforeEach
    void before() {
        fractions = new ArrayList<>();
        fractions.add(new Fraction(2, 2));
        fractions.add(new Fraction(3, 4));
        user = new User("223", "Ana", "Benerro", fractions);
    }

    @Test
    public void testConstructorWithParameters() {
        assertEquals("223", user.getId());
        assertEquals("Ana", user.getName());
        assertEquals("Benerro", user.getFamilyName());
        assertEquals(2, user.getFractions().size());
    }

    @Test
    public void testDefaultConstructor() {
        User defaultUser = new User();
        assertNull(defaultUser.getId());
        assertNull(defaultUser.getName());
        assertNull(defaultUser.getFamilyName());
        assertTrue(defaultUser.getFractions().isEmpty());
    }

    @Test
    public void testSetName() {
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }

    @Test
    public void testSetFamilyName() {
        user.setFamilyName("Smith");
        assertEquals("Smith", user.getFamilyName());
    }

    @Test
    public void testAddFraction() {
        Fraction newFraction = new Fraction(5, 6);
        user.addFraction(newFraction);
        assertTrue(user.getFractions().contains(newFraction));
    }

    @Test
    public void testFullName() {
        assertEquals("Ana Benerro", user.fullName());
    }

    @Test
    public void testInitials() {
        assertEquals("A.", user.initials());
    }

    @Test
    public void testToString() {
        assertEquals("User{id='223', name='Ana', familyName='Benerro', fractions=[2/2, 3/4]}", user.toString());
    }

}
