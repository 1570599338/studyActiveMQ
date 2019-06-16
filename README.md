# studyActiveMQ

## jmstest项目初次测试mq


###JMS的消息结构
####消息体
    消息体，JMS API定义了5中消息格式，也叫消息类型，可以使用不同形式发送接受数据，并可以兼容现有的消息格式。
    包括：TextMessage、MapMeaasge、BytesMessage、StreamMessage和ObjectMessage
    TextMessage：普通的文本的消息
    MapMeaasge：消息的结构为map类型的
    BytesMessage：消息为bytes类型
    StreamMessage：消息为流式消息
    ObjectMessage：发送一个对象类型
    

####消息属性
     消息属性，包括一下三种类型的属性：
     1、应用程序设置和添加的属性，比如：
        Message。setStringProperty("username",username);
     2、JMS定义的属性
        使用|"JMSX"作为属性的前缀  
      connection.getMetaData().getJMSPropertyNames(),方法返回所有的连接支持的JMS属性的名字。
     3、JMS供应商特定的属性如下
   
####JMS定义的属性如下：
    1、JMSUserID：发送消息的用户标识，发送时提供商设置



















