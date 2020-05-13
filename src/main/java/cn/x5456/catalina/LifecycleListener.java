package cn.x5456.catalina;

/**
 * 当组件的生命周期修改时调用
 *
 * @author Craig R. McClanahan
 */
public interface LifecycleListener {


    /**
     * Acknowledge the occurrence of the specified event.
     *
     * @param event LifecycleEvent that has occurred
     */
    public void lifecycleEvent(LifecycleEvent event);


}