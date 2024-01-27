package com.driver;

public class Email {

    String emailId;
    String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        //if(!oldPassword.equals(password)) return;//throw new PasswordDoesntMatchWithOldPassword("Old password is wrong");
//        if(newPassword.length() < 8) return;//throw new PassLengthInvalid("Kindly enter atleast 8 characters");
//        if(!doesItContainOneUpper(newPassword)) return;//throw new NoUppperCaseFound("Password must have atleast one upper case character");
//        if(!doesItContainOneLower(newPassword)) return;//throw new NoLowerCaseFound("Password must have atleast one lower case character");
//        if(!doesItContainOneDigit(newPassword)) return;//throw new NoDigitsFound("Password must have atleast one number");
//        if(!doesItContainOneSpecial(newPassword)) return;//throw new NoSpecialCharactersFound("Password must have atleast one special character");
//        boolean upper = false;
//        boolean lower = false;
//        boolean digit = false;
//        boolean special = false;
//        for(char c : newPassword.toCharArray()){
//            if(c >= 'A' && c <= 'Z') upper = true;
//            else if (c >= 'a' && c <= 'z') lower = true;
//            else if (c >= '0' && c <= '9') digit = true;
//        }
        if (oldPassword.equals(password) && newPassword.length() >= 8) {
            String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$";
            if (newPassword.matches(passwordRegex)) {
                password = newPassword;
            }
        }
    }
//    private static boolean doesItContainOneUpper(String str){
//        for(char c : str.toCharArray()){
//            if(c >= 'A' && c <= 'Z') return true;
//        }
//        return false;
//    }
//    private static boolean doesItContainOneLower(String str){
//        for(char c : str.toCharArray()){
//            if(c >= 'a' && c <= 'z') return true;
//        }
//        return false;
//    }
//    private static boolean doesItContainOneDigit(String str){
//        for(char c : str.toCharArray()){
//            if(c >= '0' && c <= '9') return true;
//        }
//        return false;
//    }
//    private static boolean doesItContainOneSpecial(String str){
//        for(char c : str.toCharArray()){
//            if(!doesItContainOneUpper(c+"") && !doesItContainOneLower(c+"") && !doesItContainOneDigit(c+"")) return true;
//        }
//        return false;
//    }

}
