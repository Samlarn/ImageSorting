import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jonss on 2018-03-13.
 *
 */
public class ProductInformationParser {

    private ArrayList<Product> products = new ArrayList<>();

    public ProductInformationParser(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Product product = null;
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                String[] lineArray = line.split(" ");
                if(lineArray[0].equals("-")) {
                    product = new Product();
                }
                else if(lineArray[2].equals("CmImgKeywordsUnibake:")) {
                    StringBuilder sb = new StringBuilder();
                    for(int i = 3; i < lineArray.length; i++) {
                        sb.append(lineArray[i]);
                    }
                    String keyWord = handleImgKeywords(sb.toString());
                    product.setCmImgKeywordsUnibake(keyWord);
                }
                else if(lineArray[2].equals("CmName:")) {
                    product.setCmName(lineArray[3]);
                }
                else if(lineArray[2].equals("CmSubCategoryUnibake:")) {
                    product.setCmSubCategoryUnibake(lineArray[3]);
                }
                else if(lineArray[2].equals("SysId:")) {
                    product.setSysId(lineArray[3]);
                }
                else if(lineArray[2].equals("filename:")) {
                    product.setFilename(lineArray[3]);
                    products.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Choose a keyword (not clean code...)
     */
    private String handleImgKeywords(String imgKeywords) {
    	
    	if(imgKeywords.toLowerCase().contains("mix")) {
    		return "mix";
    	}
    	else if(imgKeywords.toLowerCase().contains("hotdog")) {
    		return "hotdogroll";
    	}
    	else if(imgKeywords.toLowerCase().contains("burger")) {
    		return "hamburgerbun";
    	}
    	else if(imgKeywords.toLowerCase().contains("pita")) {
    		return "pita";
    	}
    	
    	return imgKeywords;
    }
    

    public ArrayList<Product> getProducts() {
        return products;
    }
}
