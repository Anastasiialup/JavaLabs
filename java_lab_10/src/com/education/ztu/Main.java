package com.education.ztu;

import com.education.ztu.game.Game;
import com.education.ztu.game.Team;
import com.education.ztu.game.Player;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("=== Завдання 1: Ініціалізація гри ===");
        Game game = new Game("Adventure", new Team("Warriors"));
        game.getTeam().addPlayer(new Player("Alice", 100));
        System.out.println(game);
        logger.info("Game initialized: " + game);
        System.out.println("Завдання 1: Completed\n");

        System.out.println("=== Завдання 2: Серіалізація ===");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("game.ser"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("game.ser"))) {
            oos.writeObject(game);
            logger.info("Game serialized to file game.ser");

            Game deserializedGame = (Game) ois.readObject();
            System.out.println("Deserialized Game: " + deserializedGame);
            logger.info("Game deserialized: " + deserializedGame);
        } catch (IOException | ClassNotFoundException e) {
            logger.error("Serialization error", e);
        }
        System.out.println("Завдання 2: Completed\n");

        System.out.println("=== Завдання 3: Логування ===");
        logger.debug("Debug log example");
        logger.warn("Warning log example");
        logger.error("Error log example");
        System.out.println("Логи записані в консоль і файл.");
        System.out.println("Завдання 3: Completed\n");

        System.out.println("=== Завдання 4: XML Парсинг ===");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Запис у XML
            String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                    + "<game name=\"Adventure\">\n"
                    + "    <team name=\"Warriors\">\n"
                    + "        <player>\n"
                    + "            <name>Alice</name>\n"
                    + "            <score>100</score>\n"
                    + "        </player>\n"
                    + "    </team>\n"
                    + "</game>";
            try (FileWriter writer = new FileWriter("example.xml")) {
                writer.write(xmlContent);
            }

            String xmlFilePath = "example.xml"; // Додано змінну для шляху до файлу XML
            logger.info("XML written to file: " + xmlFilePath);

            // Читання з XML
            Document document = builder.parse(new File(xmlFilePath));
            document.getDocumentElement().normalize();
            String gameName = document.getDocumentElement().getAttribute("name");
            String teamName = document.getElementsByTagName("team").item(0).getAttributes().getNamedItem("name").getTextContent();
            String playerName = document.getElementsByTagName("name").item(0).getTextContent();
            String playerScore = document.getElementsByTagName("score").item(0).getTextContent();

            System.out.println("Parsed from XML: Game{name='" + gameName + "', team='" + teamName + "', player{name='" + playerName + "', score=" + playerScore + "}}");
            logger.info("XML parsed successfully");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("XML Parsing error", e);
        }
        System.out.println("Завдання 4: Completed\n");

        System.out.println("=== Завдання 5: JSON Парсинг ===");
        Gson gson = new Gson();
        String json = gson.toJson(game);
        System.out.println("Serialized to JSON: " + json);

        Game gameFromJson = gson.fromJson(json, Game.class);
        System.out.println("Deserialized from JSON: " + gameFromJson);
        logger.info("Game serialized to JSON and back: " + gameFromJson);
        System.out.println("Завдання 5: Completed\n");

        System.out.println("Усі завдання виконані успішно!");
    }
}
