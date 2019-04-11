/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptwitter;

import java.util.List;
import javax.swing.JOptionPane;
import twitter4j.*;


/**
 *
 * @author fojomars
 */
public class AppTwitter {

    /**
     * @param args the command line arguments
     * @throws twitter4j.TwitterException
     */
      public static void main(String[] args) throws TwitterException {

        int opcion;
        Twitter twitter = TwitterFactory.getSingleton();
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Application Twitter"
                    + "\n1. Twittear\n2. Mostrar el tiempo"
                    + "\n3. Filtrar\n4. Salir"));
            switch(opcion){
                //Realizar un tuit
                case 1: String tuit = JOptionPane.showInputDialog("Introduzca un tuit:");
                Status st = twitter.updateStatus(tuit);
                JOptionPane.showMessageDialog(null, "El tuit ha sido realizado correctamente [" + st.getText() + "].");
                break;
                //Mostrar la línea de tiempo
                case 2: List<Status> statuses = twitter.getHomeTimeline();
                System.out.println("Mostrando el tiempo:");
                for (Status status : statuses) {
                    System.out.println(status.getUser().getName() + ":" + status.getText());
                }
                break;
                //Filtrado
                case 3: String busqueda = JOptionPane.showInputDialog("Introduzca la palabra que desea buscar:");
                Query query = new Query(busqueda);
                QueryResult result = twitter.search(query);
                for (Status status : result.getTweets()) {
                    System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
                }
                break;
                case 4: System.exit(0);
                
            }
        }while(opcion!=4);
        
    }
    
}
