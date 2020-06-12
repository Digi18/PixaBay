
package Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hit {

    @Expose
    private Long comments;
    @Expose
    private Long downloads;
    @Expose
    private Long favorites;
    @Expose
    private Long id;
    @Expose
    private Long imageHeight;
    @Expose
    private Long imageSize;
    @Expose
    private Long imageWidth;
    @Expose
    private String largeImageURL;
    @Expose
    private Long likes;
    @Expose
    private String pageURL;
    @Expose
    private Long previewHeight;
    @Expose
    private String previewURL;
    @Expose
    private Long previewWidth;
    @Expose
    private String tags;
    @Expose
    private String type;
    @Expose
    private String user;
    @SerializedName("user_id")
    private Long userId;
    @Expose
    private String userImageURL;
    @Expose
    private Long views;
    @Expose
    private Long webformatHeight;
    @Expose
    private String webformatURL;
    @Expose
    private Long webformatWidth;

    public Long getComments() {
        return comments;
    }

    public void setComments(Long comments) {
        this.comments = comments;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    public Long getFavorites() {
        return favorites;
    }

    public void setFavorites(Long favorites) {
        this.favorites = favorites;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Long imageHeight) {
        this.imageHeight = imageHeight;
    }

    public Long getImageSize() {
        return imageSize;
    }

    public void setImageSize(Long imageSize) {
        this.imageSize = imageSize;
    }

    public Long getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Long imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public Long getPreviewHeight() {
        return previewHeight;
    }

    public void setPreviewHeight(Long previewHeight) {
        this.previewHeight = previewHeight;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public Long getPreviewWidth() {
        return previewWidth;
    }

    public void setPreviewWidth(Long previewWidth) {
        this.previewWidth = previewWidth;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getWebformatHeight() {
        return webformatHeight;
    }

    public void setWebformatHeight(Long webformatHeight) {
        this.webformatHeight = webformatHeight;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public Long getWebformatWidth() {
        return webformatWidth;
    }

    public void setWebformatWidth(Long webformatWidth) {
        this.webformatWidth = webformatWidth;
    }

}
