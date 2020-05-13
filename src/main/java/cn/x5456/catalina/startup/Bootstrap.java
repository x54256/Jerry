package cn.x5456.catalina.startup;

/**
 * 根据不同的启动命令调用不同的方法
 *
 * @author yujx
 * @date 2020/05/11 13:47
 */
public class Bootstrap {

    private static Bootstrap daemon = new Bootstrap();

    private Catalina catalinaDaemon = null;

    public static void main(String[] args) {

        // 初始化启动器
        daemon.init();

        // 设置Server实例启动完成之后是否进入等待状态的标识
        daemon.setAwait(true);

        // 最终调用了Catalina.load()方法，通过Digester解析conf/server.xml文件生成Server对象，设置到Catalina的server参数中
        daemon.load();

        // 最终调用了Catalina.start()方法，启动server实例
        daemon.start();
    }

    private void init() {

        // 初始化 3 个类加载器（暂时不做），然后使用新创建的类加载器加载 Catalina 类，然后为其设置类加载器
        catalinaDaemon = new Catalina();
    }

    private void setAwait(boolean await) {
        catalinaDaemon.setAwait(await);
    }

    private void load() {
        catalinaDaemon.load();
    }

    private void start() {
        catalinaDaemon.start();
    }

}
