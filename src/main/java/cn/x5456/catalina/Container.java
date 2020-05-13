package cn.x5456.catalina;

public interface Container extends Lifecycle {

    /**
     * 获取容器名
     */
    String getName();

    /**
     * 设置容器名
     */
    void setName(String name);

    /**
     * 获取父容器
     */
    Container getParent();

    /**
     * 设置父容器
     */
    void setParent(Container container);

    /**
     * 后台运行进程
     */
    void backgroundProcess();

    /**
     * 添加子容器
     */
    void addChild(Container child);

    /**
     * 根据名称获取子容器
     */
    Container findChild(String name);

    /**
     * 获取所有的子容器
     */
    Container[] findChildren();

    /**
     * 获取管道对象
     */
    Pipeline getPipeline();
}