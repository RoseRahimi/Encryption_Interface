package encryption;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EncryptorInterfaceTest {

	private ScytaleCipher scy;
	private CaesarCipher caesar;
	private Copy copy;

	@BeforeEach
	void setUp() throws Exception {
		scy = new ScytaleCipher();
		caesar = new CaesarCipher();
		copy = new Copy();
	}

	@Test
	void EncryptedTest() {

		assertEquals("adr  itathlhigmro ", scy.encryptText("a third algorithm", 6));
	}

	@Test
	void DeccryptedTest() {

		assertEquals("a third algorithm ", scy.DecryptText("adr  itathlhigmro ", 6));

	}

	@Test
	void NotLegalLengthTest() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			ScytaleCipher scy = new ScytaleCipher();
			scy.DecryptText("adr  itathlhigmro", 6);
		});

		assertEquals("Invalid ciphertext length", exception.getMessage());
	}

	@Test
	void wrapAroundTest() {

		String encrypted = caesar.encryptText("~", 131);
		int value = encrypted.charAt(0);
		assertEquals(2, value);
	}

	@Test
	void testEncrpttext() {
		assertEquals("gdkkn", caesar.encryptText("hello", -1));
		assertEquals("hello", caesar.encryptText("gdkkn", 1));
	}

	@Test
	void testDecryption() {
		assertEquals("hello", caesar.DecryptText("gdkkn", -1));
		assertEquals("~", caesar.DecryptText("!", 162));
	}

	@Test
	void CTest() {

		assertEquals("hello", copy.encryptText("hello", 0));
		assertEquals("hello", copy.DecryptText("hello", 0));
	}

}
