package cn.x5456.catalina.startup;

import cn.x5456.catalina.Server;

/**
 * @author yujx
 * @date 2020/05/11 13:57
 */
public class Catalina {

    private boolean await = false;

    private Server server = null;

    public void setAwait(boolean await) {
        this.await = await;
    }

    /**
     * 从 server.xml 中解析出 Server 对象，所以会加载到 Host 那
     */
    public void load() {
        server = null;
    }

    public void start() {

        // 启动当前服务器实例
        server.start();

        // 如果设置等待 SHUTDOWN 命令，则调用服务器实例的 await 方法
        if (await) {
            // 等待关闭命令
            server.await();

            // 关闭服务器实例
            server.stop();
            server.destroy();
        }
    }
}
