public class Feedback {

    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;


public Feedback(String firstName,String lastName,String email){
    this.firstName=firstName;
    this.lastName=lastName;
    this.email=email;
   }
   public String getFirstName(){
    return firstName;
   }
   public String getLastName(){
    return lastName;
   }
   public String getEmail(){
    return email;
   }        
   public String getCompleteFeedback(){
    return completeFeedback;
   }
   public String getReviewID(){
    return reviewID;
   }
   public boolean isLongFeedback(){
    return longFeedback;
   }
public void analyseFeedback(boolean isConcatenation,String sent1,String sent2,String sent3,String sent4,String sent5){
    if(isConcatenation==true){
        completeFeedback=feedbackUsingConcatenation(sent1,sent2,sent3,sent4,sent5);
    }else {
        completeFeedback=feedbackUsingStringBilder(sent1,sent2,sent3,sent4,sent5).toString();
        checkFeedbackLength(completeFeedback);
        createReviewID(firstName,lastName,completeFeedback);
    }
     
    
}
private String feedbackUsingConcatenation(String sent1,String sent2,String sent3,String sent4,String sent5){
String concatenatedFeedback="";
concatenatedFeedback+=sent1;
concatenatedFeedback+=sent2;
concatenatedFeedback+=sent3;
concatenatedFeedback+=sent4;
concatenatedFeedback+=sent5;
return concatenatedFeedback;
}


private StringBuilder   feedbackUsingStringBilder (String sent1, String sent2, String sent3, String sent4,String sent5) {
    StringBuilder sb=new StringBuilder();
    sb.append(sent1);
    sb.append(sent2);
    sb.append(sent3);
    sb.append(sent4);
    sb.append(sent5);
    return sb;
}
private boolean checkFeedbackLength(String feedback){
    longFeedback=feedback.length()>500;
    return longFeedback;
}
private void createReviewID(String firstName,String lastName,String completeFeedback){
    String namePart=(firstName+lastName).substring(2,6).toUpperCase();
    String feedbackPart=completeFeedback.substring(0,2).toUpperCase();
    reviewID=namePart+feedbackPart;
}

public static void main(String[] args){
    String sent1="I was very satisfied with the service.";
    String sent2="The e-Bike is quite comfortable to ride.";
    String sent3="The battery life of the e-Bilke is impressive.";
    String sent4="The customer support was helpful and responsive.";
    String sent5="I would recommend this e-Bilke to my friends and family.";
    
    Feedback feedback = new Feedback("John","Doe","john.doe@example.com");

    feedback.analyseFeedback(true,sent1,sent2,sent3,sent4,sent5);

    System.out.println("User:"+feedback.getFirstName()+""+feedback.getLastName());
    System.out.println("Email:"+feedback.getEmail());
    System.out.println("Review ID:"+feedback.getReviewID());
    System.out.println("Is long feedback?"+feedback.isLongFeedback());
    System.out.println("Complete Feedback:\n"+feedback.getCompleteFeedback());
}
}

    

