import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Regular expression patterns used in top Android apps.
class ApplicationPatterns{
    public static final Pattern AMAZON_CRASH_DESCRIPTOR_UTIL = Pattern.compile("([a-zA-Z0-9_\\.\\$]+(Exception|Error|TerribleFailure))|(at\\s.*\\(.*\\))|#\\d+\\s+pc\\s+[\\w\\d]+\\s+([^\\+^\\r^\\n]+)");
}
