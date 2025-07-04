import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateForm {
    private Pattern pattern;
    private Matcher matcher;
    private final String PHONE_REGEX = "^(03|05|07|08)[0-9]{8}$";
    private final String EMAIL_REGEX = "^[a-z0-9.]+@([a-z0-9]+\\.){1,2}[a-z0-9]{2,6}$";


    public boolean phone(String regex ) {
        pattern = Pattern.compile(PHONE_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean email(String regex ) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
