
import java.util.ArrayList;

/**
 * Created by jonss on 2018-03-13.
 */
public class Main {

    public static void main(String[] args) {

    	int lastImageDirectory = 26;
    	
        String path = "D:/Images/";

        for(int i = 0; i <= lastImageDirectory; i++) {
            String imageInformationFile = path + "images_"+i+".yml";

            // Parse the image information from the image information file
            ProductInformationParser parser = new ProductInformationParser(imageInformationFile);
            ArrayList<Product> products = parser.getProducts();

            // Create and sort images to their sub Category.
            DirectoryHandler directoryHandler = new DirectoryHandler(path);
            directoryHandler.sortImagesToDirectories(products);
        }
       
        
        System.out.println("Sorting finished!");
    }
}
