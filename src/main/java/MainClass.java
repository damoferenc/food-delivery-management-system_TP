import Business.DeliveryService;
import Data.Serializator;
import Presentation.Controller;
import Presentation.LogInGUI;

import java.io.*;

public class MainClass {

    public static void main(String args[]){
        DeliveryService deliveryService = null;
        deliveryService = Serializator.deserializeDeliveryService();
        Serializator.serializeDeliveryService(deliveryService);


        LogInGUI logInGUI = new LogInGUI();
        Controller controller = new Controller(logInGUI, deliveryService);
        logInGUI.setVisible(true);


    }
}
