package com.ashupan.loginservice.constants;

/*THIS CLASS CONTAINS CUSTOM ERROR MESSAGES FOR VARIOUS EXCEPTIONS*/
public class ErrorMessageConstants {

	public interface ForgetPassword {
        String DEVELOPER_MESSAGE = "Password didn't match with the original one.";
        String MESSAGE = "Incorrect password.Forgot Password?";
    }
	
	public interface InvalidAppUserUsername {
        String DEVELOPER_MESSAGE = "AppUser entity returned null";
        String MESSAGE = "AppUser with given username doesn't exits.";
    }
}
