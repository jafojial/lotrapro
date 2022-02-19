import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 * Afficher une carte GoogleMap dans un JEditorPane
 * @author fobec 2010
 */
@SuppressWarnings("serial")
public class JGoogleMapEditorPan extends JEditorPane {

    private int zoomFactor = 7;
    private String ApiKey = "";
    private String roadmap = "roadmap";
    public final String viewTerrain = "terrain";
    public final String viewSatellite = "satellite";
    public final String viewHybrid = "hybrid";
    public final String viewRoadmap = "roadmap";

    /**
     * Constructeur: initialisation du EditorKit
     */
    public JGoogleMapEditorPan() {
        HTMLEditorKit kit = new HTMLEditorKit();
        HTMLDocument htmlDoc = (HTMLDocument) kit.createDefaultDocument();
        this.setEditable(false);
        this.setContentType("text/html");
        this.setEditorKit(kit);
        this.setDocument(htmlDoc);
    }

    /**
     * Fixer le zoom
     * @param zoom valeur de 0 à 21
     */
    public void setZoom(int zoom) {
        this.zoomFactor = zoom;
    }

    /**
     * Fixer la clé de developpeur
     * @param key APIKey fourni par Google
     */
    public void setApiKey(String key) {
        this.ApiKey = key;
    }

    /**
     * Fixer le type de vue
     * @param roadMap
     */
    public void setRoadmap(String roadMap) {
        this.roadmap = roadMap;
    }

    /**
     * Afficher la carte d'après des coordonnées GPS
     * @param latitude
     * @param longitude
     * @param width
     * @param height
     * @throws Exception erreur si la APIKey est non renseignée
     */
    public void showCoordinate(String latitudeClient, String longitudeClient,String lattitudePop, String longitudePop, int width, int height) throws Exception {
        this.setMap(latitudeClient, longitudeClient, lattitudePop, longitudePop, width, height);
    }

    /**
     * Afficher la carte d'après une ville et son pays
     * @param city
     * @param country
     * @param width
     * @param height
     * @throws Exception erreur si la APIKey est non renseignée
     */
    public void showLocation(String city, String country, int width, int height) throws Exception {
        this.setMap(city, country, city, country, width, height);
    }

    /**
     * Assembler l'url et Générer le code HTML
     * @param x
     * @param y
     * @param width
     * @param height
     * @throws Exception
     */
    private void setMap(String x, String y, String a, String b, Integer width, Integer height) throws Exception {
        if (this.ApiKey.isEmpty()) {
            throw new Exception("Developper API Key not set !!!!");
        }

        String url = "http://maps.google.com/maps/api/staticmap?";
        url += "center=" + x + "," + y;
        url += "&amp;zoom=" + this.zoomFactor;
        url += "&amp;size=" + width.toString() + "x" + height.toString();
        url += "&amp;maptype=" + this.roadmap;
        url += "&amp;markers=color:green%7Clabel:C%7C" + x + "," + y;
        url += "&amp;markers=color:red%7Clabel:P%7C" + a + "," + b;
        url += "&amp;path=color:0x0000ff%7Cweight:5%7C"+x+","+y+"|"+a+","+b;
        url += "&amp;sensor=false";
        url += "&amp;key=" + this.ApiKey;

        String html = "<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>";
        html += "<html><head></head><body>";
        html += "<img src='" + url + "'>";
        html += "</body></html>";
        this.setText(html);
    }

    /**
     * Exemple : JGoogleMapEditorPan dans un JFrame
     */
   
}