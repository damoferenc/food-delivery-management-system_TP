package Presentation;

import Business.BaseProduct;
import Business.DeliveryService;
import Business.MenuItem;
import Data.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


    private LogInGUI logInGUI;
    private List<AdministratorGUI> admins;
    private List<ClientGUI> clients;
    private List<EmployeeGUI> employees;
    private DeliveryService deliveryService;
    public Controller(LogInGUI logInGUI, DeliveryService deliveryService){
        this.logInGUI = logInGUI;
        this.admins = new ArrayList<AdministratorGUI>();
        this.clients = new ArrayList<ClientGUI>();
        this.employees = new ArrayList<EmployeeGUI>();
        this.deliveryService = deliveryService;
        this.logInGUI.addLogInButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = deliveryService.searchUser(logInGUI.getUsername(), logInGUI.getPassword());
                if(user == null){
                    logInGUI.setError("Client not found, please register");
                }
                else{
                    logInGUI.setError("");
                    if(user.getRole() == Role.ADMINISTRATOR){
                        AdministratorGUI administratorGUI = new AdministratorGUI((Administrator) user);
                        admins.add(administratorGUI);
                        administratorGUI.setVisible(true);
                        administratorGUI.addImportButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                deliveryService.initialImport();
                            }
                        });
                        administratorGUI.addAddButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                deliveryService.addProduct(administratorGUI.getTitle(), administratorGUI.getRating(),
                                        administratorGUI.getCalories(), administratorGUI.getProtein(),
                                        administratorGUI.getFat(), administratorGUI.getSodium(),
                                        administratorGUI.getPrice());
                            }
                        });
                        administratorGUI.addDeleteButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                deliveryService.removeProduct(administratorGUI.getTitle());
                            }
                        });
                        administratorGUI.addModifyButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                deliveryService.editProduct(administratorGUI.getTitle(), administratorGUI.getRating(),
                                        administratorGUI.getCalories(), administratorGUI.getProtein(),
                                        administratorGUI.getFat(), administratorGUI.getSodium(),
                                        administratorGUI.getPrice());
                            }
                        });
                        administratorGUI.addAddToCompositeButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String name = administratorGUI.getCompositeName();
                                MenuItem menuItem = deliveryService.getProduct(name);
                                if(menuItem != null) {
                                    ((Administrator) user).addToComposeList(menuItem);
                                }
                            }
                        });
                        administratorGUI.addAddCompositeButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                deliveryService.addProduct(((Administrator) user).getComposeList(),
                                        administratorGUI.getCompositeName());
                                ((Administrator) user).deleteComposeList();
                            }
                        });
                        administratorGUI.addTimeIntervalReportButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                deliveryService.generateTimeIntervalReport(administratorGUI.getStartHour(),
                                        administratorGUI.getEndHour());
                            }
                        });
                        administratorGUI.addOrderedMoreReportButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                deliveryService.generateOrderedMoreReport(administratorGUI.getNumber());
                            }
                        });
                        administratorGUI.addClientsReportButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                deliveryService.generateReport3(administratorGUI.getReport3Value1(),
                                        administratorGUI.getReport3Value2());
                            }
                        });
                        administratorGUI.addSpecifiedDayReportButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                deliveryService.generateReport4(administratorGUI.getDate());
                            }
                        });
                    }
                    if(user.getRole() == Role.CLIENT){
                        ClientGUI clientGUI = new ClientGUI((Client) user);
                        clients.add(clientGUI);
                        clientGUI.setVisible(true);
                        clientGUI.addShowAllButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                clientGUI.setProductList(deliveryService.getAllProducts());
                            }
                        });
                        clientGUI.addSearchTitleButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                clientGUI.setProductList(deliveryService.searchTitle(clientGUI.getTitle()));
                            }
                        });
                        clientGUI.addSearchRatingButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                clientGUI.setProductList(deliveryService.searchRating(clientGUI.getRating()));
                            }
                        });
                        clientGUI.addSearchCaloriesButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                clientGUI.setProductList(deliveryService.searchCalories(clientGUI.getCalories()));
                            }
                        });
                        clientGUI.addSearchProteinButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                clientGUI.setProductList(deliveryService.searchProtein(clientGUI.getProtein()));
                            }
                        });
                        clientGUI.addSearchFatButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                clientGUI.setProductList(deliveryService.searchFat(clientGUI.getFat()));
                            }
                        });
                        clientGUI.addSearchSodiumButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                clientGUI.setProductList(deliveryService.searchSodium(clientGUI.getSodium()));
                            }
                        });
                        clientGUI.addSearchPriceButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                clientGUI.setProductList(deliveryService.searchPrice(clientGUI.getPrice()));
                            }
                        });
                        clientGUI.addAddToOrderButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String name = clientGUI.getOrderElement();
                                MenuItem menuItem = deliveryService.getProduct(name);
                                if(menuItem != null) {
                                    ((Client) user).addToList(menuItem);
                                    LocalDateTime now = LocalDateTime.now();
                                    menuItem.addDate(dtf.format(now));
                                }
                            }
                        });
                        clientGUI.addAddOrderButtonListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                LocalDateTime now = LocalDateTime.now();
                                int totalPrice = deliveryService.addOrder(((Client)user).getClientID(),dtf.format(now),
                                        ((Client)user).getList());
                                String text = "New order:";
                                for(MenuItem menuItem : ((Client)user).getList()){
                                    text += menuItem.toString() + " ";
                                }
                                deliveryService.notifyAllObservers(text);
                                ((Client)user).deleteList();
                                ((Client)user).addToOrderValues(totalPrice);
                            }
                        });
                    }
                    if(user.getRole() == Role.EMPLOYEE){
                        EmployeeGUI employeeGUI = new EmployeeGUI(user);
                        employees.add(employeeGUI);
                        employeeGUI.setVisible(true);
                        deliveryService.attach(employeeGUI);
                    }
                }
            }
        });
        this.logInGUI.addSerializeButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Serializator.serializeDeliveryService(deliveryService);
            }
        });

        this.logInGUI.addRegisterButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deliveryService.addClient(logInGUI.getUsername(), logInGUI.getPassword());
                logInGUI.setError("");
            }
        });
    }

}
