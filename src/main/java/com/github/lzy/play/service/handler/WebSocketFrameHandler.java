/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.github.lzy.play.service.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.lzy.play.domain.Message;
import com.github.lzy.play.enums.MessageType;
import com.github.lzy.play.model.InteractionModel;
import com.github.lzy.play.service.IMessageService;
import com.github.lzy.play.service.SpringContextHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

/**
 * Echoes uppercase content of text frames.
 */
public class WebSocketFrameHandler extends SimpleChannelInboundHandler<WebSocketFrame> {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketFrameHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
        // ping and pong frames already handled

        if (frame instanceof TextWebSocketFrame) {
            // Send the uppercase string back.
            String request = ((TextWebSocketFrame) frame).text();
            logger.info("{} received {}", ctx.channel(), request);
	        InteractionModel interactionModel = JSON.parseObject(request, InteractionModel.class);
	        if (MessageType.SEND_MSG.equals(interactionModel.getType())) {
	        	// send msg
		        Message message = JSON.parseObject(interactionModel.getPayload(), Message.class);
		        IMessageService bean = SpringContextHolder.getBean(IMessageService.class);
		        bean.sendMessage(message);
	        }
	        ctx.channel().writeAndFlush(new TextWebSocketFrame(request.toUpperCase(Locale.US)));
        } else {
            String message = "unsupported frame type: " + frame.getClass().getName();
            throw new UnsupportedOperationException(message);
        }
    }
}
