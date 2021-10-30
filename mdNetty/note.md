## date 25-JULY

### 服务端：
```
public void start() throws Exception{
	final EchoServerHandler serverHandler = new EchoServerHandler(); // 业务逻辑在此体现
	EventLoopGroup group = new NioEventLoopGroup(); // 接受和处理新的连接
	try{
		ServerBootstrap b = new ServerBootstrap();
		b.group(group)
			.channel(NioServerSocketChannel.class) // 指定Nio
			.localAddress(new InetSocketAddress(port)) // 绑定端口
			// 当一个新的连接被接受时，一个新的子channel将被创建。
			// 这里的 ChannelInitializer 会把一个 EchoServerHandler 的实例添加到该 Channel 的 pipeline 中
			.childHandler(new ChannelInitializer<SocketChannel>()){ 
				@Override
				public void initChannel(SocketChannel ch) throw Exception{
					ch.pipeline().addLast(serverHandler);
				}
			}
			
		ChannelFuture f = b.bind().sync();
		f.channel().closeFuture().sync();
	} finally{
		group.shutdownGracefully().sync();
	}

}
```

### Netty 的组件与设计：
* Channel --- Socket
  基本的 I/O 操作（bind，connect，read， write）依赖于底层网络传输所提供的源语。
  在基于 java 的网络变成中，其基本的构造是 class socket
* EventLoop --- 控制流、多线程处理、并发
  定义了 Netty 的核心抽象，用于处理连接的生命周期中所发生的事件。
  1. 一个 EventLoopGroup 包含一个或者多个 EventLoop
  2. 一个 EventLoopGroup 在它的生命周期内只和一个 Thread 绑定
  3. 所有由 EventLoopGroup 处理的 I/O 事件都将在它专有的 Thread 上被处理
  4. 一个 Channel 在它的生命周期只注册于一个 EventLoopGroup
  5. 一个 EventLoopGroup 可能会被分配一个或多个 Channel
* ChannelFuture --- 异步通知
  Netty 的所有 I/O 操作都是异步的。
  因为一个操作可能不会立即返回，所以需要一种用于在之后的某个时间点确定其结果的方法。
* ChannelHandler 
  所有处理入站和出站数据的应用的容器。
* ChannelPipeline
  为 ChannelHandler 链提供了容器，并定义了用于在该链上传播入站和出站事件流的 API。当 ChannelHandler 被创建时，会自动被分配到专属的 ChannelPipeline
  1. 一个 ChannelInitializer 的实现被注册到 ServerBootstrap 中
  2. 当 ChannelInitializer.initChannel() 被调用时，ChannelInitializer 将在 ChannelPipeline 中安装一组自定义的 ChannelHandler
  3. ChannelInitializer 将自己从 ChannelPipeline 中移除
