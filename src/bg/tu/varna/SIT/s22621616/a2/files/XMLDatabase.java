package bg.tu.varna.SIT.s22621616.a2.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLDatabase {
    private String filePath;

    public XMLDatabase(String filePath) {
        this.filePath = filePath;
    }

    public List<XMLElement> readXML() {
        List<XMLElement> elements = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                XMLElement element = parseElement(line.trim());
                if (element != null) {
                    elements.add(element);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elements;
    }

    private XMLElement parseElement(String line) {
        if (line.startsWith("<") && line.endsWith(">")) {
            String name = line.substring(1, line.indexOf(">"));
            String value = line.substring(line.indexOf(">") + 1, line.lastIndexOf("<"));
            return new XMLElement(name, value);
        }
        return null;
    }

    public void writeXML(List<XMLElement> elements) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (XMLElement element : elements) {
                writer.write("<" + element.getName() + ">" + element.getValue() + "</" + element.getName() + ">");
                writer.newLine();
            }
            System.out.println("XML file has been written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        XMLDatabase xmlHandler = new XMLDatabase(filePath);

        // Reading from XML file
        List<XMLElement> elements = xmlHandler.readXML();
        if (!elements.isEmpty()) {
            System.out.println("XML file has been read successfully.");
            for (XMLElement element : elements) {
                System.out.println(element);
            }
        }

        // Writing to XML file
        List<XMLElement> dataToWrite = new ArrayList<>();
        dataToWrite.add(new XMLElement("root", ""));
        dataToWrite.add(new XMLElement("item", "Some data", "id=\"1\""));
        dataToWrite.add(new XMLElement("item", "More data", "id=\"2\""));
        xmlHandler.writeXML(dataToWrite);
    }
}

class XMLElement {
    private String name;
    private String value;
    private String attributes;

    public XMLElement(String name, String value, String attributes) {
        this.name = name;
        this.value = value;
        this.attributes = attributes;
    }

    public XMLElement(String name, String value) {
        this(name, value, "");
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return "<" + name + " " + attributes + ">" + value + "</" + name + ">";
    }
}

