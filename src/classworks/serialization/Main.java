package classworks.serialization;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

public class Main {

    public static void main(String[] args) throws
            IOException,
            ClassNotFoundException {

        LaunchStat stat;
        File statFile = new File("stat.bin");

        if(!statFile.exists()) {
            stat = new LaunchStat();
        }
        else {
            try(ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(statFile)
            )){
                stat = (LaunchStat) ois.readObject();
            }
        }
        if (stat.isFirstLaunch()) {
            System.out.println("First launch");
        }
        else {
            System.out.println(stat.toString());
        }

        stat.updateStat();

        try (ObjectOutputStream oouts = new ObjectOutputStream(
                new FileOutputStream(statFile)
        )) {
            oouts.writeObject(stat);
        }
    }
}
