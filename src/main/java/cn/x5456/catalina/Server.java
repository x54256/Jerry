package cn.x5456.catalina;

import cn.x5456.catalina.startup.Catalina;

/**
 * @author yujx
 * @date 2020/05/11 14:05
 */
public interface Server extends Lifecycle {

    /**
     * @return the port number we listen to for shutdown commands.
     */
    public int getPort();


    /**
     * Set the port number we listen to for shutdown commands.
     *
     * @param port The new port number
     */
    public void setPort(int port);


    /**
     * @return the address on which we listen to for shutdown commands.
     */
    public String getAddress();


    /**
     * Set the address on which we listen to for shutdown commands.
     *
     * @param address The new address
     */
    public void setAddress(String address);


    /**
     * @return the shutdown command string we are waiting for.
     */
    public String getShutdown();


    /**
     * Set the shutdown command we are waiting for.
     *
     * @param shutdown The new shutdown command
     */
    public void setShutdown(String shutdown);

    /**
     * @return the outer Catalina startup/shutdown component if present.
     */
    public Catalina getCatalina();

    /**
     * Set the outer Catalina startup/shutdown component if present.
     *
     * @param catalina the outer Catalina component
     */
    public void setCatalina(Catalina catalina);

    /**
     * Add a new Service to the set of defined Services.
     *
     * @param service The Service to be added
     */
    public void addService(Service service);



    /**
     * Find the specified Service
     *
     * @param name Name of the Service to be returned
     * @return the specified Service, or <code>null</code> if none exists.
     */
    public Service findService(String name);


    /**
     * @return the set of Services defined within this Server.
     */
    public Service[] findServices();


    /**
     * Remove the specified Service from the set associated from this
     * Server.
     *
     * @param service The Service to be removed
     */
    public void removeService(Service service);

    /**
     * 等待直到收到正确的关机命令，然后返回。
     */
    public void await();
}
