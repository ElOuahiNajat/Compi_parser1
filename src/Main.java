//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] testStrings = {
                "cdcbc", "bcdcbcb", "cbdcbdcbc", "ccdcbcdcbcdcbbcr", "cdcbbb", "cdcb", ""
        };

        for (String test : testStrings) {
            RecursiveDescentParser parser = new RecursiveDescentParser(test);
            System.out.printf("Input: %-20s Result: %s\n", test, parser.parse() ? "accepte" : "rejete");
        }
    }
}