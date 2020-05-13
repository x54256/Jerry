package cn.x5456.catalina;

/**
 * 描述一个Valve集合的接口，在调用invoke（）方法时应按顺序执行这些阀门。
 * 要求管道中某个地方的Valve（通常是最后一个）必须处理请求并创建相应的响应，而不是尝试传递请求。
 */
public interface Pipeline {


    // ------------------------------------------------------------- Properties


    Valve getBasic();


    public void setBasic(Valve valve);


    // --------------------------------------------------------- Public Methods


    void addValve(Valve valve);


    /**
     * @return the set of Valves in the pipeline associated with this
     * Container, including the basic Valve (if any).  If there are no
     * such Valves, a zero-length array is returned.
     */
    Valve[] getValves();


    /**
     * Remove the specified Valve from the pipeline associated with this
     * Container, if it is found; otherwise, do nothing.  If the Valve is
     * found and removed, the Valve's <code>setContainer(null)</code> method
     * will be called if it implements <code>Contained</code>.
     *
     * <p>Implementation note: Implementations are expected to trigger the
     * {@link Container#REMOVE_VALVE_EVENT} for the associated container if this
     * call is successful.</p>
     *
     * @param valve Valve to be removed
     */
    void removeValve(Valve valve);


    /**
     * @return the Valve instance that has been distinguished as the basic
     * Valve for this Pipeline (if any).
     */
    Valve getFirst();


    /**
     * @return the Container with which this Pipeline is associated.
     */
    public Container getContainer();


    /**
     * Set the Container with which this Pipeline is associated.
     *
     * @param container The new associated container
     */
    public void setContainer(Container container);

}
