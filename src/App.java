
import java.io.ObjectInputFilter.Config;
import javax.naming.directory.SearchResult;
import java.awt.Desktop;
import java.net.URI;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

public class App {
    
    public static void main(String[] args) throws Exception {
        Configuration config=new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us"); //To get the language
        config.setDictionaryPath("src\\dic.dic"); //setting dic path
        config.setLanguageModelPath("src\\lm.lm"); //setting language model path

        try {
            LiveSpeechRecognizer rec=new LiveSpeechRecognizer(config);
            rec.startRecognition(true);
            Desktop desk=Desktop.getDesktop();

            while (rec.getResult()!=null) {
                String result=rec.getResult().getHypothesis();

                /* 
                System.out.println(result);
                for testing purpose
                */ 

                if(result.toLowerCase().equals("google")){

                    URI uri=new URI("https://www.google.com");
                    System.out.println("Opening: "+ result);
                    desk.browse(uri);

                }
                else if (result.toLowerCase().equals("youtube")){

                    URI uri=new URI("https://www.youtube.com");
                    System.out.println("Opening: "+ result);
                    desk.browse(uri);
                }
                else if (result.toLowerCase().equals("facebook")){

                    URI uri=new URI("https://www.facebook.com");
                    System.out.println("Opening: "+ result);
                    desk.browse(uri);
                }
                else if (result.toLowerCase().equals("github")){

                    URI uri=new URI("https://www.github.com");
                    System.out.println("Opening: "+ result);
                    desk.browse(uri);
                }
                else if (result.toLowerCase().equals("gmail")){

                    URI uri=new URI("https://www.gmail.com");
                    System.out.println("Opening: "+ result);
                    desk.browse(uri);
                }
                else if (result.toLowerCase().equals("hackerrank")){

                    URI uri=new URI("https://www.hackerrank.com");
                    System.out.println("Opening: "+ result);
                    desk.browse(uri);
                }
                else if (result.toLowerCase().equals("whatsapp")){

                    URI uri=new URI("https://web.whatsapp.com/");
                    System.out.println("Opening: "+ result);
                    desk.browse(uri);
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println(e);
        }


    }
}
