# 项目简介

学习rabbitmq的测试项目

# 存在问题

Caused by: com.rabbitmq.client.ShutdownSignalException: connection error; protocol method: #method<connection.close>(reply-code=530, reply-text=NOT_ALLOWED - access to vhost '/' refused for user 'admin', class-id=10, method-id=40)



## 学习记录

经过一段时间的学习,目前对Rabbitmq基本有一些了解了,也运行了一些demo.

## TODO

- 总结知识,梳理知识,背诵面试题,熟悉界面和代码关键
- 插件实现延迟队列(目前没开始是因为我的Rabbitmq的版本是3.6.10,官网插件我目前没发现支持这个版本的)
- 发布确认高级
- 集群

## 问题

### 权限问题

Caused by: com.rabbitmq.client.ShutdownSignalException: connection error; protocol method: #method<connection.close>(reply-code=530, reply-text=NOT_ALLOWED - access to vhost **'/'** refused for user 'admin', class-id=10, method-id=40)

改一下权限即可

# 参考

[RabbitMQ安装与运行](https://blog.csdn.net/jobjava/article/details/117607437)

[ubuntu和centos安装包不一样](https://blog.csdn.net/jobjava/article/details/117607437)