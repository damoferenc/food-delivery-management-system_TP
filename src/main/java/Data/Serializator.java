package Data;

import Business.DeliveryService;

import java.io.*;

public class Serializator {

    public static DeliveryService deserializeDeliveryService(){
        DeliveryService deliveryService = null;
        try {
            System.out.println("Searching for deliveryService");
            FileInputStream fileIn = new FileInputStream("deliveryService.ser");
            if(fileIn == null){
                System.out.println("file not found");
            }
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deliveryService = (DeliveryService) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found, creating new class");
            deliveryService = new DeliveryService();
        }
        catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        catch (Exception e){
            System.out.println("ERROR");
            e.printStackTrace();
        }
        return deliveryService;
    }

    public static void serializeDeliveryService(DeliveryService deliveryService){
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("deliveryService.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deliveryService);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
