import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

/**
 * Created by jonss on 2018-03-13.
 */
public class DirectoryHandler {

    private String path;

    
    public DirectoryHandler(String path) {
        this.path = path;
    }


    public void sortImagesToDirectories(ArrayList<Product> products) {
        try {
            for(Product product : products) {
                String subCategory = product.getCmSubCategoryUnibake();
                String pathToSortedImages = "sorted_images/" + subCategory + "/";
                String newDirPath = path + pathToSortedImages;
                String pathToInformationFile = newDirPath + subCategory+".txt";
                String pathToImageFile = path + product.getFilename();
                
                // Create directory
                createDirectory(newDirPath);
                
                // Write the products information to the correct text file.
                String keyword = writeToInformationFile(pathToInformationFile, product, subCategory);
                
                // Create sub category directory
                String subCategoryDir = newDirPath + keyword + "/";
                createDirectory(subCategoryDir);
                
                // Copy the image file to the correct directory.
                copyImageFileToNewPath(pathToImageFile, subCategoryDir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    /*
     * Copies an image and puts the copy in a given destination path.  
     */
    private void copyImageFileToNewPath(String imgSrcPath, String destinationPath) throws IOException {
        File imageFile = new File(imgSrcPath);
        Files.copy(imageFile.toPath(),
                (new File(destinationPath + imageFile.getName())).toPath(),
                StandardCopyOption.REPLACE_EXISTING);
    }
    
    /*
     * Create a directory in the given path. 
     */
    private void createDirectory(String newDirPath) throws IOException {
        File f = new File(newDirPath);
        boolean dirCreated = f.mkdir();
        if(dirCreated) {
            System.out.println(dirCreated);
            f.createNewFile();
        }
    }
    
    /* 
     * Write to information file.
     */
    private String writeToInformationFile(String pathToInformationFile, Product product, String subCategory) throws IOException {
    	FileWriter fileWriter = new FileWriter(pathToInformationFile, true);
    	Writer writer = new BufferedWriter(fileWriter);
        writer.write("#--------- new product --------------\n");
        String keyword = handleKeyWords(product.getCmImgKeywordsUnibake(), subCategory);
        String sysId = product.getSysId().substring(1, (product.getSysId().length()-1));
        product.setPathTo(keyword + "/" + sysId + ".png"); 
        writer.write(keyword+"\n");
        writer.write(sysId+"\n");
        writer.write(product.getPathTo()+"\n");
        writer.write(product.getCmName()+"\n");
        writer.close();
        
        return keyword;
    }
    
    /*
     * handle the keywords.
     */
    private String handleKeyWords(String keywords, String subCategory) {
    	if(subCategory.toLowerCase().equals("fastfood")) {
    		return handleFastFood(keywords);
    	}
    	else if(subCategory.toLowerCase().equals("pastry")) {
    		return handlePastry(keywords);
    	}
    	else if(subCategory.toLowerCase().equals("croissant")) {
    		return handleCroissant(keywords);
    	}
    	else if(subCategory.toLowerCase().equals("retail")) {
    		return handleRetail(keywords);
    	}
    	else if(subCategory.toLowerCase().equals("softdoughtcakes")) {
    		return handleSoftdoughtcakes(keywords);
    	}
    	else if(subCategory.toLowerCase().equals("bread")) {
    		return handleBread(keywords);
    	}
    	
    	return keywords;
    }
    
    
    // -------- Here comes the if-else mess... --------------------------------------
    
    /*
     * change keyword for softdough cakes.
     */
    private String handleSoftdoughtcakes(String imgKeywords) {
		if(imgKeywords.toLowerCase().contains("mix")) {
			return "mix";
		}
		else if(imgKeywords.toLowerCase().contains("softdough")) {
			return "softdough";
		}
		else if(imgKeywords.toLowerCase().contains("mutiservecake")) {
			return "mutiservecake";
		}
		else if(imgKeywords.toLowerCase().contains("traycake")) {
			return "traycake";
		}
		else if(imgKeywords.toLowerCase().contains("donuts")) {
			return "donuts";
		}
		else if(imgKeywords.toLowerCase().contains("muffins")) {
			return "muffins";
		}
		else if(imgKeywords.toLowerCase().contains("cookie")) {
			return "cookie";
		}
		else if(imgKeywords.toLowerCase().contains("specialityproducts")) {
			return "specialityproducts";
		}
		
    	return imgKeywords;
    }
    
    /*
     * change keyword for retail.
     */
    private String handleRetail(String imgKeywords) {
		if(imgKeywords.toLowerCase().contains("mix")) {
			return "mix";
		}
		else if(imgKeywords.toLowerCase().contains("fastfood")) {
			return "fastfood";
		}
		else if(imgKeywords.toLowerCase().contains("softdough")) {
			return "softdough";
		}
		else if(imgKeywords.toLowerCase().contains("specialityproductsforretail")) {
			return "specialityproductsforretail";
		}
		return imgKeywords;
    }
    
    /* change keyword for croissants.
     */
    private String handleCroissant(String imgKeywords) {
		if(imgKeywords.toLowerCase().contains("mix")) {
			return "mix";
		}
		else if(imgKeywords.toLowerCase().contains("curved")) {
			return "curved";
		}
		else if(imgKeywords.toLowerCase().contains("straight")) {
			return "straight";
		}
		
		return imgKeywords;
	}

    /* change keyword for fastfood.
     */
	private String handleFastFood(String imgKeywords) {
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
    
    /* change keyword for pastry.
     */
    private String handlePastry(String imgKeywords) {
    	if(imgKeywords.toLowerCase().contains("mix")) {
    		return "mix";
    	}
    	else if(imgKeywords.toLowerCase().contains("crown")) {
    		return "crown";
    	}
    	else if(imgKeywords.toLowerCase().contains("swirl")) {
    		return "swirl";
    	}
    	else if(imgKeywords.toLowerCase().contains("fan")) {
    		return "fan";
    	}
    	else if(imgKeywords.toLowerCase().contains("pecan")) {
    		return "pecan";
    	}
    	else if(imgKeywords.toLowerCase().contains("specialitypastry")) {
    		return "specialitypastry";
    	}
    	else if(imgKeywords.toLowerCase().contains("lattice")) {
    		return "lattice";
    	}

    	return imgKeywords;
    }
    
    /*
     * change keyword for bread.
     */
    private String handleBread(String imgKeywords) {
    	if(imgKeywords.toLowerCase().contains("mix")) {
    		return "mix";
    	}
    	else if(imgKeywords.toLowerCase().contains("baguette")) {
    		return "baguette";
    	}
    	else if(imgKeywords.toLowerCase().contains("cibatta")) {
    		return "cibatta";
    	}
    	else if(imgKeywords.toLowerCase().contains("toast")) {
    		return "toast";
    	}
    	else if(imgKeywords.toLowerCase().contains("sandwichbread")) {
    		return "sandwichbread";
    	}
    	else if(imgKeywords.toLowerCase().contains("loaf")) {
    		return "loaf";
    	}
    	else if(imgKeywords.toLowerCase().contains("roll")) {
    		return "roll";
    	}
    	else if(imgKeywords.toLowerCase().contains("bun")) {
    		return "bun";
    	}
    	else if(imgKeywords.toLowerCase().contains("ryebread")) {
    		return "ryebread";
    	}
    	else if(imgKeywords.toLowerCase().contains("panini")) {
    		return "panini";
    	}
    	else if(imgKeywords.toLowerCase().contains("foccacia")) {
    		return "foccacia";
    	}
    	else if(imgKeywords.toLowerCase().contains("bagel")) {
    		return "bagel";
    	}
    	else if(imgKeywords.toLowerCase().contains("rawdough")) {
    		return "rawdough";
    	}
    	else if(imgKeywords.toLowerCase().contains("pretzel")) {
    		return "pretzel";
    	}
    	else if(imgKeywords.toLowerCase().contains("specialitybread")) {
    		return "specialitybread";
    	}
    	
    	return imgKeywords;
    }
    
}

