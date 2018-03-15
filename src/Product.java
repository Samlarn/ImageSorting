/**
 * Created by jonss on 2018-03-13.
 * Product object class.
 */
public class Product {

    private String cmImgKeywordsUnibake = "x";
    private String cmName = "x";
    private String cmSubCategoryUnibake = "x";
    private String sysId = "x";
    private String filename = "x";
    private String pathTo = "x";


    public String getCmImgKeywordsUnibake() {
        return cmImgKeywordsUnibake;
    }

    public void setCmImgKeywordsUnibake(String cmImgKeywordsUnibake) {
        this.cmImgKeywordsUnibake = cmImgKeywordsUnibake;
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName;
    }

    public String getCmSubCategoryUnibake() {
        return cmSubCategoryUnibake;
    }

    public void setCmSubCategoryUnibake(String cmSubCategoryUnibake) {
        this.cmSubCategoryUnibake = cmSubCategoryUnibake;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public String getPathTo() {
    	return pathTo;
    }
    
    public void setPathTo(String pathTo) {
    	this.pathTo = pathTo;
    }
}
