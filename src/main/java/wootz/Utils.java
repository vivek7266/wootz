package wootz;

import java.util.Collections;

public class Utils {
    public String removeQuotes(String arg) {
        boolean doubleQuoteStr = (arg.startsWith("\"") && arg.endsWith("\""));
        boolean singleQuoteStr = (arg.startsWith("'") && arg.endsWith("'"));
        if ((singleQuoteStr | doubleQuoteStr) && arg.length() > 2) {
            arg = arg.substring(1, arg.length() - 1);
        }
        return arg;
    }

    public String toLowerAndRemoveHyphens(String arg){
        return arg.toLowerCase().replace("-", "");
    }

    public String setProperName(String layerName){
        layerName = removeQuotes(layerName);
        layerName = toLowerAndRemoveHyphens(layerName);
        return layerName;
    }

    public static void indentNextLine(StringBuilder code, int indent) {
        for (int i = 0; i < indent; i++){
            code.append("\t");
        }
    }

    public static String indent(String str, int level, boolean useSpaces, int numSpaces) {
        String prefix;
        if (!useSpaces) {
            prefix = String.join("", Collections.nCopies(level, "\t"));
        } else {
            String spaces = String.join("", Collections.nCopies(numSpaces, " "));
            prefix = String.join("", Collections.nCopies(level, spaces));
        }

        String indented = str.replaceAll("(?m)^", prefix);
        return indented;
    }
}
