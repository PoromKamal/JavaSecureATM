public class Validation{
    /*
    This class will handle the backend of ATMSecure. This includes validating logins,
    adding users to the users.txt database, and encrypting data from the sign-up.
    */
    public static String validateSignupFields(String data, String password, String confirmPassword){
        /*
        This method will go through the data inputted by the user, and confirm
        whether they follow the following rules:
            * Every field must have an input
            * Password must be atleast 10 characters
            * The password must match the confirmed password
            * (Check whether the current username is unique) This will be done after doing the encryption stuff
        It will return a string representing what is wrong with the file, otherwise it will return "valid".
        */
        String errorMessage = "";
        //1. Check if every field has an input
        for(int i = 0; i < data.length()-1; i++){
            if(data.charAt(i) == '/' && data.charAt(i+1) == '/'){
                errorMessage += "All fields must have an input.\n";
                break;
            }
        }
        
        //2. Check if password is atleast 10 characters.
        if(password.length() < 10){
            errorMessage += "Password must be atleast 10 characters.\n";
        }

        //3. Check if the password matches the confirm password.
        if(!(password.equals(confirmPassword))){
            errorMessage += "Password and Confirm password must match.\n";
        }

        return errorMessage;
    }
}
