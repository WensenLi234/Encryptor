public class Encryptor
{
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    /** Constructor*/
    public Encryptor(int r, int c)
    {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock()
    {
        return letterBlock;
    }

    /** Places a string into letterBlock in row-major order.
     *
     *   @param str  the string to be processed
     *
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str)
    {
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(i * numCols + j > str.length() - 1) {
                    letterBlock[i][j] = "A";
                } else {
                    letterBlock[i][j] = str.substring(i * numCols + j, i * numCols + j + 1);
                }
            }
        }
    }

    /** Extracts encrypted string from letterBlock in column-major order.
     *
     *   Precondition: letterBlock has been filled
     *
     *   @return the encrypted string from letterBlock
     */
    public String encryptBlock()
    {
        String encrypted = "";
        for(int i = 0; i < numCols; i++) {
            for(int j = 0; j < numRows; j++) {
                encrypted += letterBlock[j][i];
            }
        }
        return encrypted;
    }
    public String decryptBlock() {
        String decrypted = "";
        for(int i = numCols - 1; i > 0; i--) {
            for(int j = numRows; j > 0; j--) {
                if(decrypted)
            }
        }
    }
    /** Encrypts a message.
     *
     *  @param message the string to be encrypted
     *
     *  @return the encrypted message; if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message)
    {
        String encryptedMessage = "";
        for(int i = 0; i < message.length(); i += numRows * numCols) {
            fillBlock(message.substring(i));
            encryptedMessage += encryptBlock();
        }
        return encryptedMessage;
    }
    /**  Decrypts an encrypted message. All filler 'A's that may have been
     *   added during encryption will be removed, so this assumes that the
     *   original message (BEFORE it was encrypted) did NOT end in a capital A!
     *
     *   NOTE! When you are decrypting an encrypted message,
     *         be sure that you have initialized your Encryptor object
     *         with the same row/column used to encrypted the message! (i.e.
     *         the “encryption key” that is necessary for successful decryption)
     *         This is outlined in the precondition below.
     *
     *   Precondition: the Encryptor object being used for decryption has been
     *                 initialized with the same number of rows and columns
     *                 as was used for the Encryptor object used for encryption.
     *
     *   @param encryptedMessage  the encrypted message to decrypt
     *
     *   @return  the decrypted, original message (which had been encrypted)
     *
     *   TIP: You are encouraged to create other helper methods as you see fit
     *        (e.g. a method to decrypt each section of the decrypted message,
     *         similar to how encryptBlock was used)
     */
    public String decryptMessage(String encryptedMessage)
    {
        String decryptedMessage = encryptMessage(encryptedMessage);

        return decryptedMessage;
    }
    public String removeFiller(String encryptedMessage) {
        String newMessage = encryptedMessage;
        for(int i = newMessage.length() - 1; i > 0; i--) {
            if(newMessage.charAt(i) == 'A') {
                newMessage = newMessage.substring(0, i);
            }
        }
        return newMessage;
    }
}