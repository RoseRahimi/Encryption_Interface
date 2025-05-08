//Rose Rahimi
package encryption;

/**
 *an interface implementation for different encyption algorithms 
 * @method encryptText which returns a string that has been incrypted by any of the algorithms
 * @method DecryptText which returns a string that has been diciphered by any of the algorithms
 */

public interface EncryptorInterface {

	public String encryptText(String plainText, int Key);

	public String DecryptText(String Hash, int Key);

}
