import mazeMinotaur.Hero;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroTest {
    private Hero hero;

    @Before
    public void init() {
        hero = new Hero();
    }

    @After
    public void afterTest() {
        hero = null;
    }

    @Test
    public void apply() {
        assertEquals(15, hero.getHealth() + 5);
    }

    @Test
    public void move() {
    }

    @Test
    public void isDead() {
    }

    @Test
    public void heroIsTired() {

    }
}
