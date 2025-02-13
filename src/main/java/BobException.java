/**
 * BobException is a custom exception class specific to the Bob chatbot.
 * It is used to handle errors related to user commands, input validation,
 * and other chatbot-specific issues.
 */

public class BobException extends Exception{
    public BobException(String message){
        super(message);
    }
}
