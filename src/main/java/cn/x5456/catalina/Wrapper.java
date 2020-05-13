package cn.x5456.catalina;

/**
 * @author yujx
 * @date 2020/05/11 15:32
 */
public interface Wrapper extends Container {

    /**
     * @return the fully qualified servlet class name for this servlet.
     */
    public String getServletClass();


    /**
     * Set the fully qualified servlet class name for this servlet.
     *
     * @param servletClass Servlet class name
     */
    public void setServletClass(String servletClass);


    /**
     * Gets the names of the methods supported by the underlying servlet.
     *
     * This is the same set of methods included in the Allow response header
     * in response to an OPTIONS request method processed by the underlying
     * servlet.
     *
     * @return Array of names of the methods supported by the underlying
     *         servlet
     */
    public String[] getServletMethods();

    /**
     * @return the associated Servlet instance.
     */
    public Servlet getServlet();


    /**
     * Set the associated Servlet instance
     *
     * @param servlet The associated Servlet
     */
    public void setServlet(Servlet servlet);


    public Servlet allocate();

    /**
     * Add a mapping associated with the Wrapper.
     *
     * @param mapping The new wrapper mapping
     */
    public void addMapping(String mapping);

    /**
     * @return the mappings associated with this wrapper.
     */
    public String[] findMappings();
}
