package groupe1.filrouge;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestClient.class, TestCommandePiece.class, TestCommandeVehicule.class, TestDevis.class, TestPiece.class,
		TestTache.class, TestVehicule.class })
public class AllTests {

}
