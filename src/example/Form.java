package example;

import Model.Client;

import java.util.ArrayList;
import java.util.Map;

public class Form {
    public static void main(String[] args) {

        ArrayList<Client> clients = new ArrayList<Client>();

        Client c1 = new Client("Michel","Bernard");
        Client c2 = new Client("Castafior","Christine");

        clients.add(546,c1);
        clients.add(547,c2);
    }
}
