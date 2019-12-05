package softuni.winelovers.common;

public class Constants {
    public final static String REGISTER_EMAIL_SUBJECT = "Email confirmation - WINE LOVERS";
    public final static String REGISTER_EMAIL_TEXT = "Welcome to wine lovers private club. To start using our site we have to confirm" +
            "your email. You can copy and paste the following code %s or just click" +
            "<a href='http://localhost:8000/users/confirm-email?id=%s'>HERE.</a> Cheers!" +
            " If you receive this email without your knowledge, you dno't have to panic, we will block the registration attempt";
}
