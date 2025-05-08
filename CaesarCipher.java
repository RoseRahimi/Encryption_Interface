//Rose Rahimi
package encryption;

/**
 * The Caesar cipher is a very simple algorithm. Each letter is shifted a
 * constant amount.
 * 
 */

public class CaesarCipher implements EncryptorInterface {

	/**
	 * @param takes a plain text and key by which the shift should happens
	 * 
	 * @return it returns an encrypted string
	 */
	public String encryptText(String plainText, int Key) {

		StringBuilder encrypted = new StringBuilder();

		// to store the encrypted massage
		char[] chars = plainText.toCharArray();

		// changing the plain text to array of characters and adding key to it
		for (char c : chars) {
			// two layer casting to get a char back
			char c1 = (char) (((int) c + Key) % 255);
			encrypted.append(c1);
		}

		return encrypted.toString();
	}

	/**
	 * @param takes a Hash and key by which the shift should happens
	 * @return it returns an Decrypted string
	 */
	public String DecryptText(String Hash, int Key) {

		StringBuilder decrypted = new StringBuilder();

		// to store the encrypted massage
		char[] chars = Hash.toCharArray();

		// changing the plain text to array of characters and adding key to it
		for (char c : chars) {
			int value = ((int) c - Key) % 255;

			// making sure that it wraps around
			if (value < 0) {
				value += 255;
			}

			char c1 = (char) value;
			decrypted.append(c1);
		}

		return decrypted.toString();

	}

}
