package twitter4j;

import java.util.List;
import javax.swing.JOptionPane;
import twitter4j.*;

public class JTwitter {

    /**
     * metodo que trata el uso de este programa con argumentos
     *
     * @param args - argumentos de ejecucion
     * *@throws twitter4j.TwitterException
     */
    public static void main(String[] args) throws TwitterException {

        int opcion;
        Twitter twitter = TwitterFactory.getSingleton();
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Application Twitter"
                    + "\n1. Twittear\n2. Mostrar el tiempo"
                    + "\n3. Filtrar\n4. Salir"));
            switch (opcion) {

                case 1://Timeline
                    List<Status> statuses = twitter.getHomeTimeline();
                    System.out.println("Timeline: ");
                    statuses.forEach((status) -> {
                        System.out.println(status.getUser().getName() + ":" + status.getText());
                    });
                    break;
                    
                case 2://Tweet
                    String tuit = JOptionPane.showInputDialog("Escribe un tweet: ");
                    Status st = twitter.updateStatus(tuit);
                    JOptionPane.showMessageDialog(null, "Tweet publicado [" + st.getText() + "].");
                    break;

                case 3://Search Tweets
                    String busqueda = JOptionPane.showInputDialog("Escribe tu busqueda: ");
                    Query query = new Query(busqueda);
                    QueryResult result = twitter.search(query);
                    result.getTweets().forEach((status) -> {
                        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
                    });
                    break;
                case 4:
                    System.exit(0);

            }
        } while (opcion != 4);

    }

}
