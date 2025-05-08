//Rose Rahimi
package encryption;

/**
 * The Scytale cipher is a cipher that uses transposition rather than
 * substitution, meaning that it changes the order of letters. This algorithm
 * works by first writing the letters in rows with a fixed number of columns.
 */
public class ScytaleCipher implements EncryptorInterface {

	/**
	 * @ param plaintext to be encrypted
	 * 
	 * @ param key to be encrypted by what order
	 * 
	 * @return the encrypted string
	 */

	public String encryptText(String plainText, int Key) {
		// need a string builder here because I add padding into it before encryption
		StringBuilder encrypted = new StringBuilder(plainText);

		// adding white spaces, if the length is not a multiple of a key
		while (encrypted.length() % Key != 0) {
			encrypted.append(" ");
		}
		// number of rows for the transpose
		int rows = encrypted.length() / Key;

		char[] chars = encrypted.toString().toCharArray();
		// emptying out the string builder
		encrypted.setLength(0);

		// reading the array column wise
		for (int j = 0; j < Key; j++) {
			for (int i = 0; i < rows; i++) {
				// index is the order of transpose
				int index = (i * Key) + j;
				encrypted.append(chars[index]);
			}
		}
		return encrypted.toString();
	}

	/**
	 * @param Hash to be converted to plainText
	 * 
	 * @param Key  what key will give you the right answer
	 * 
	 * @return a String which is decrypted text
	 */

	public String DecryptText(String Hash, int Key) {

		StringBuilder decrypted = new StringBuilder(Hash);

		// giving an error if the Hash is not a multiple of key indicating a wrong hash
		// entry
		while (decrypted.length() % Key != 0) {
			throw new IllegalArgumentException("Invalid ciphertext length");
		}

		// rows
		int rows = decrypted.length() / Key;

		char[] chars = decrypted.toString().toCharArray();

		decrypted.setLength(0);

		// going through rows and column to decipher
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < Key; j++) {
				int index = (j * rows) + i;
				decrypted.append(chars[index]);

			}
		}

		return decrypted.toString();
	}

}
