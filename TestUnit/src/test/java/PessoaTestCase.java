import entity.Pessoa;
import junit.framework.TestCase;
import org.junit.jupiter.api.*;

public class PessoaTestCase extends TestCase{
    private static Pessoa pessoa;
    private static Integer testNumber = 0;


    @BeforeAll
    static void setup() {
        System.out.println("Instanciando entity.Pessoa Teste\n");
        String fullnameTest = "John Doe Roberto Santos";
//        LocalDate birthdayTest = LocalDate.of(1999, 10, 2);
        String birthdayTest = "02/10/1999";
        pessoa = new Pessoa(fullnameTest, birthdayTest);
    }

    @BeforeEach
    void avisoAntes() {
        testNumber += 1;
        System.out.println("Iniciando Teste #"+testNumber);
    }

    @AfterEach
    void avisoDepois() {
        System.out.println("Teste #"+testNumber+" concluído!\n");
    }

    @Test
    @DisplayName("Test Set Name/LastName")
    public void testNames(){
        String expectedName = "John";
        String expectedLastname = "Santos";

        assertEquals(expectedName, pessoa.getName());
        assertEquals(expectedLastname, pessoa.getLastname());

    }

    @Test
    @DisplayName("Test Set Age")
    void testBirthday() {
        Integer expectedAge = 22;
        assertEquals(expectedAge, pessoa.getIdade());

    }

    @Test
    @DisplayName("Test Valid CPF")
    void testCPF() throws Exception {
        String expectedCPF = "66127411041";
        pessoa.setDocumentoCPF(expectedCPF);

        assertEquals("661.274.110-41", pessoa.getDocumentoCPF());
    }

    @Test
    @Disabled("Test disabled\n")
    void anyTest() {
    }
}
