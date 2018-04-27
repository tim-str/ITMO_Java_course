package classworks.serialization;

import java.io.*;

public class Main_extended {
    public static void main(String[] args) throws
            IOException,
            ClassNotFoundException {
        LaunchStatExtern stat;
        File statFile = new File("stat2.bin");

        if(!statFile.exists()) {
            stat = new LaunchStatExtern();
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(statFile)
            )){
                stat = (LaunchStatExtern) ois.readObject();
            }
        }

        if (stat.isFirstLaunch()){
            System.out.println("First launch");
        } else {
            System.out.println(stat.toString());
        }

        stat.updateStat();

        try (ObjectOutputStream oouts = new ObjectOutputStream(
                new FileOutputStream(statFile)
        )){
            oouts.writeObject(stat);
        }
    }
}

// Шилдт Java8 Полное руководство

// Хорстман Корнелл Java Библиотека профессионала
