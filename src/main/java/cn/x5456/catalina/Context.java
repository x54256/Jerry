package cn.x5456.catalina;

/**
 * @author yujx
 * @date 2020/05/11 15:28
 */
public interface Context extends Container {

    /**
     * @return the context path for this web application.
     */
    public String getPath();


    /**
     * Set the context path for this web application.
     *
     * @param path The new context path
     */
    public void setPath(String path);

    /**
     * Obtain the document root for this Context.
     *
     * @return An absolute pathname, a relative pathname, or a URL.
     */
    public String getDocBase();


    /**
     * Set the document root for this Context.  This can be an absolute
     * pathname, a relative pathname, or a URL.
     *
     * @param docBase The new document root
     */
    public void setDocBase(String docBase);

    /**
     * @return the Loader with which this Context is associated.
     */
    public Loader getLoader();

    /**
     * Set the Loader with which this Context is associated.
     *
     * @param loader The newly associated loader
     */
    public void setLoader(Loader loader);

    /**
     * @return the Resources with which this Context is associated.
     */
    public WebResourceRoot getResources();

    /**
     * Set the Resources object with which this Context is associated.
     *
     * @param resources The newly associated Resources
     */
    public void setResources(WebResourceRoot resources);

    // filter Listener 暂略
}
