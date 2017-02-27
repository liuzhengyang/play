package com.github.lzy.play.service;

import com.github.lzy.play.service.handler.WebSocketFrameHandler;
import com.github.lzy.play.service.handler.WebSocketIndexPageHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-27
 */
@Service
public class WebSocketService {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketService.class);
	private static final String WEBSOCKET_PATH = "/ws";

	private int port = 8081;

	@PostConstruct
	public void startMessageWsServer() {
		new Thread(this::startWs, "wx-server").start();
	}

	private void startWs() {
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(boss, worker)
				.channel(NioServerSocketChannel.class)
				.childHandler(new ChannelInitializer<NioSocketChannel>() {
					@Override
					protected void initChannel(NioSocketChannel ch) throws Exception {
						ChannelPipeline pipeline = ch.pipeline();
						pipeline.addLast(new HttpServerCodec());
						pipeline.addLast(new HttpObjectAggregator(65536));
						pipeline.addLast(new WebSocketServerCompressionHandler());
						pipeline.addLast(new WebSocketServerProtocolHandler(WEBSOCKET_PATH, null, true));
						pipeline.addLast(new WebSocketIndexPageHandler(WEBSOCKET_PATH));
						pipeline.addLast(new WebSocketFrameHandler());
					}
				}).handler(new LoggingHandler(LogLevel.DEBUG))
				.localAddress(port);
		try {
			ChannelFuture bind = bootstrap.bind().sync();
			LOGGER.info("Bind Server at {}", port);
			bind.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
