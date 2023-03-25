## 启动准备
- 改src/main/resources/application.yml的配置
- mysql password:
- imageBaseUrl:
- crypto:
  key: 123456 改成和前端一致
- src/main/java/com/test/im/netty/CoordinationNettyServer.java 修改第32行.localAddress(8004), 这里的端口号改成和前端一致即可
- 导入sql文件到数据库中

## 启动
待maven下载完jar包即可运行

## 注意
一个浏览器只能登录一个用户，可以开多个浏览器进行聊天
