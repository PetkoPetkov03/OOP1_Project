package bg.tu.varna.SIT.s22621616.a2.files;

abstract public class XML {
    public StringBuilder genElement(String element, String content) {
        StringBuilder line = new StringBuilder();
        line.append("<").append(element).append(">").append(content).append("</").append(element).append(">");
        return line;
    }

    public StringBuilder genElement(String element, boolean closing) {
        StringBuilder line = new StringBuilder();

        line.append("<");
        if(closing) {
            line.append("/");
        }
        line.append(element).append(">");
        return line;
    }
}
