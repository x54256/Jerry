package cn.x5456.catalina;

import java.io.File;

/**
 * @author yujx
 * @date 2020/05/11 15:25
 */
public interface Host extends Container {

    /**
     * @return the application root for this Host.  This can be an absolute
     * pathname, a relative pathname, or a URL.
     */
    public String getAppBase();


    /**
     * @return an absolute {@link File} for the appBase of this Host. The file
     * will be canonical if possible. There is no guarantee that that the
     * appBase exists.
     */
    public File getAppBaseFile();


    /**
     * Set the application root for this Host.  This can be an absolute
     * pathname, a relative pathname, or a URL.
     *
     * @param appBase The new application root
     */
    public void setAppBase(String appBase);
}
