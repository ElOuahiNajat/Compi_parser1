public class RecursiveDescentParser {
    private String input;
    private int pos;

    public RecursiveDescentParser(String input) {
        this.input = input + "$";
        this.pos = 0;
    }


    private char currentToken() {
        if (pos < input.length()) {
            return input.charAt(pos);
        }
        return '\0';
    }


    private boolean consume(char expected) {
        if (currentToken() == expected) {
            pos++;
            return true;
        }
        return false;
    }


    private boolean parseS() {
        if (consume('b')) {
            if (parseS()) {
                return consume('b');
            }
            return false;
        } else if (consume('c')) {
            if (parseA()) {
                return consume('c');
            }
            return false;
        }
        return false;
    }


    private boolean parseA() {
        if (consume('b')) {
            if (parseA() && parseA()) {
                return true;
            }
            return false;
        } else if (consume('c')) {
            if (parseA() && consume('S') && parseA() && consume('b')) {
                return true;
            }
            return false;
        } else if (consume('d')) {
            return consume('c') && consume('b'); 
        }
        return false;
    }


    public boolean parse() {
        if (parseS() && currentToken() == '$') {
            return true;
        }
        return false;
    }



}

