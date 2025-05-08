//ROSE RAHIMI
package encryption;

/**
 * This class just copies over the user input without any changes
 */

public class Copy implements EncryptorInterface {

	/**
	 * @return return back the plaintext
	 */
	public String encryptText(String plainText, int Key) {
		return plainText;

	}

	/**
	 * @return returning back the hash
	 */
	public String DecryptText(String Hash, int Key) {
		return Hash;

	}

}
