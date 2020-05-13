package cn.x5456.catalina.core;

import cn.x5456.catalina.LifecycleState;
import cn.x5456.catalina.Server;
import cn.x5456.catalina.Service;
import cn.x5456.catalina.startup.Catalina;
import cn.x5456.catalina.util.LifecycleBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yujx
 * @date 2020/05/11 14:27
 */
public class StandardServer extends LifecycleBase implements Server {

    /**
     * The port number on which we wait for shutdown commands.
     */
    private int port = 8005;

    /**
     * The address on which we wait for shutdown commands.
     */
    private String address = "localhost";

    /**
     * The set of Services associated with this Server.
     */
    private List<Service> services = new ArrayList<>();


    /**
     * The shutdown command string we are looking for.
     */
    private String shutdown = "SHUTDOWN";

    private Catalina catalina;

    // LifecycleBase 中的实现

    @Override
    protected void initInternal() {
        // 初始化 service
        for (Service service : services) {
            service.init();
        }
    }

    @Override
    protected void startInternal() {
        // 设置生命周期为启动中
        super.setState(LifecycleState.STARTING, null);

        // 启动服务实例
        for (Service service : services) {
            service.start();
        }
    }

    // Server 接口的实现

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getShutdown() {
        return shutdown;
    }

    @Override
    public void setShutdown(String shutdown) {
        this.shutdown = shutdown;
    }

    @Override
    public Catalina getCatalina() {
        return catalina;
    }

    @Override
    public void setCatalina(Catalina catalina) {
        this.catalina = catalina;
    }

    @Override
    public void addService(Service service) {
        services.add(service);
    }

    @Override
    public Service findService(String name) {
        for (Service service : services) {
            if (service.getName().equals(name)) {
                return service;
            }
        }
        return null;
    }

    @Override
    public Service[] findServices() {
        return services.toArray(new Service[0]);
    }

    @Override
    public void removeService(Service service) {
        services.remove(service);
    }

    @Override
    public void await() {
        // TODO: 2020/5/11 监听端口等待 SHUTDOWN 命令来临时取消阻塞
    }
}
