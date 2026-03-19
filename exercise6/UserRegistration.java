package exercise6;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class UserRegistration{
    public static final  double  VIP_DISCOUNT_UNDER_18_BIRTHDAY=0.75;
    public static final  double VIP_DISCOUNT_UNDER_18=0.8;
    public static final  int VIP_BASE_FEE=100;

    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardProvider;

    String cardExpiryDate;
    private  double totalFee;
    private int cvv;

    private String userType;
    private boolean emailValid;
    private boolean minorAndBirthday;
    private boolean minor;
    private boolean ageValid;//–一个布尔值，用于指示用户的年龄是否有效
    private boolean cardNumberValid;//–一个布尔值，用于指示用户提供的卡号是否有效
    private boolean cardStillValid;//–一个布尔值，用于指示卡片是否已过期
    private boolean validCVV;//–一个布尔值，用于指示用户提供的CVV是否有效


    private Scanner scanner=new Scanner(System.in);

    public void registration(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Welcome to the ERyder Registration.");
        System.out.println("Here are your two options:");
        System.out.println("1.Register as a Regular User");
        System.out.println("2.Register as a VIP User");
        System.out.println("Please enter your choice(1 or 2):");

        int choice=scanner.nextInt();
        scanner.nextLine();

        if (choice==1){
            userType="Regular User";
        }else{
            userType="VIP User";
        }

        System.out.println("Enter youor full name:");
        fullName=scanner.nextLine();

        System.out.println("Enter your email address:");
        emailAddress=scanner.nextLine();
        emailValid=analyseEmail(emailAddress);

        System.out.println("Enter your date of birth(YYYY-MM-DD:");
        dateOfBirth=scanner.nextLine();
        LocalDate dob =LocalDate.parse(dateOfBirth);
        ageValid=analyseAge(dob);

        System.out.println("We accept VISA,MasterCard,American Express.");

        System.out.println("Please enter your card number:");
        cardNumber=sc.nextLong();
        sc.nextLine();
        System.out.println(("Checking your card number's validity..."));
        cardNumberValid=analyseCardNumber(cardNumber);

        if(!cardNumberValid){
            System.out.println("Sorry,but we accept only VISA,MasterCard,or American Express cards.");
            System.out.println("Going back to the start of the reistration.");
            registration();
            return;
        }
        System.out.println("Plesse enter the card expiry date(MM/YY):");
        cardExpiryDate=sc.nextLine();

        System.out.println("Checking if your card is still valid..");
        cardStillValid=analyseCardExpiryDate(cardExpiryDate);

        System.out.println("Please enter your CVV:");
        cvv=sc.nextInt();
        System.out.println("Checking your CVV's validity");
        validCVV=analyseCVV(cvv);

        finalCheckpoint();
        scanner.close();
    }
    private boolean analyseEmail(String email){
        if (email.contains("@")&&email.contains(".")){
            System.out.println("Email is valid");
            return true;
        }else{
            System.out.println("Invaild email address.Going back.");
            registration();
            return false;
        }
    }

    private boolean analyseAge(LocalDate dob){
        LocalDate now=LocalDate.now();
        int age=Period.between(dob,now).getYears();

        boolean isBirthday=(now.getMonth()==dob.getMonth()
                &&now.getDayOfMonth()==dob.getDayOfMonth());
        minorAndBirthday=false;
        minor=false;

        if(userType.equals("VIP User")){
            if(isBirthday&&age<=18&&age>12){
                System.out.println("Happy birthday!You get extra discount.");
                minorAndBirthday=true;
            }
        }
        if(age<=12||age>=120){
            System.out.println("You can't be our user.");
            System.exit(0);
        }
        return true;
    }

    private boolean analyseCardNumber(long number){
        String numStr=Long.toString(number);
        int len=numStr.length();

        cardProvider="";

        if((len==13||len==16)&&numStr.startsWith("4")){
            cardProvider="VISA";
            return true;
        }
        if(len==16){
            int firstTwo=Integer.parseInt(numStr.substring(0,2));
            int firstFour=Integer.parseInt(numStr.substring(0,4));
            if((firstTwo>=51&&firstTwo<=55)||(firstFour>=2221&&firstFour<=2720)){
                cardProvider="MasterCard";
                return true;
            }
        }

        if(len==15&&(numStr.startsWith("34")||numStr.startsWith("37"))){
            cardProvider="American Express";
            return true;
        }
        return false;
    }


    private boolean analyseCardExpiryDate(String expiry){
        String[]parts=expiry.split("/");
        int month=Integer.parseInt(parts[0]);
        int year=Integer.parseInt(parts[1])+2000;

        LocalDate now=LocalDate.now();
        int currYear=now.getYear();
        int currMonth=now.getMonthValue();

        if(year<currYear||(year==currYear&&month<currMonth)){
            System.out.println("The card has expired.Going back.");
            registration();
            return false;
        }
        return true;
    }

    private boolean analyseCVV(int cvv){
        String cvvStr=Integer.toString(cvv);
        int len=cvvStr.length();

        if(cardProvider.equals("American Express")){
            if(len==4){
                System.out.println("Card CVV is valid");
                return true;
            }
        } else{
            if(len==3){
                System.out.println("Card CVV is valid");
                return true;
            }
        }
        System.out.println("Invalid CVV.Going back.");
        registration();
        return false;
    }
    private void finalCheckpoint(){
        if (emailValid&&ageValid&&cardNumberValid&&cardStillValid&&validCVV){
            chargeFees();
        }else{
            System.out.println("Sorry,registration unsuccessful.");
            System.out.println("Going back.");
            registration();
        }
    }

    private void chargeFees() {
        double feeToCharge;
        if (minorAndBirthday) {
            feeToCharge = VIP_BASE_FEE * (100 - VIP_DISCOUNT_UNDER_18_BIRTHDAY) / 100;
        } else if (minor) {
            feeToCharge = VIP_BASE_FEE * (100 - VIP_DISCOUNT_UNDER_18) / 100;
        } else {
            feeToCharge = VIP_BASE_FEE;
        }

        String numStr = Long.toString(cardNumber);
        String lastFour = numStr.substring(numStr.length() - 4);

        System.out.println("Thank you for your payment.");
        System.out.println("A fee of " + feeToCharge + " has been charged to your card ending with " + lastFour);
    }

    @Override
    public String toString() {
        String numStr = Long.toString(cardNumber);
        int len = numStr.length();
        String starPart = "*".repeat(len - 4);
        String lastFour = numStr.substring(len - 4);
        String hidden = starPart + lastFour;

        return "Registration successful! Here are your details:\n"
                + "User Type: " + userType + "\n"
                + "Full Name: " + fullName + "\n"
                + "Email Address: " + emailAddress + "\n"
                + "Date of Birth: " + dateOfBirth + "\n"
                + "Card Number: " + hidden + "\n"
                + "Card Provider: " + cardProvider + "\n"
                + "Card Expiry Date: " + cardExpiryDate;
    }

}