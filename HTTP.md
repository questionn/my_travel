-  生成HTTP请求消息

1. URL的各种格式

![img](file:///F:/%E6%9C%89%E9%81%93%E4%BA%91%E7%AC%94%E8%AE%B0/weixinobU7VjnspAWEhOHHCQhci1iqUFZw/d2d4a8c728e5411ab868bc75511f859c/clipboard.png)

不同的头（HTTP，ftp)会访问不同的服务器

2.浏览器解析URL

![img](file:///F:/%E6%9C%89%E9%81%93%E4%BA%91%E7%AC%94%E8%AE%B0/weixinobU7VjnspAWEhOHHCQhci1iqUFZw/bbd49faaed104516a27ad7786745a372/clipboard.png)

注：浏览器的URL可以省略去写

3.HTTP基本传输过程

![img](file:///F:/%E6%9C%89%E9%81%93%E4%BA%91%E7%AC%94%E8%AE%B0/weixinobU7VjnspAWEhOHHCQhci1iqUFZw/6da1e0236610411d9af81f06c075d825/clipboard.png)

①请求消息

![img](file:///F:/%E6%9C%89%E9%81%93%E4%BA%91%E7%AC%94%E8%AE%B0/weixinobU7VjnspAWEhOHHCQhci1iqUFZw/e0fe96498578419caa3a26315a53d9fb/clipboard.png)

基本请求行就已经大致了解请求内容，但后面消息头，消息体会对其进行相应的补充

方法：一般为GET或POST

![img](file:///F:/%E6%9C%89%E9%81%93%E4%BA%91%E7%AC%94%E8%AE%B0/weixinobU7VjnspAWEhOHHCQhci1iqUFZw/58e66914604b4a0fa7c37716e6f73d0b/clipboard.png)

- 向DNS服务器查询WEB服务器的IP地址

生成请求之后，会查询得到WEB服务器的IP地址，然后才能发送请求



①TCP/IP结构网络，都是由许多子网连接起来的，并且每个接入网络的计算机都会得到一个IP地址

②IP地址：

③子网掩码：

④域名解析：通过DNS查询IP地址称为域名解析，所以负责解析的这一过程就叫做解析器（解析器实际是一段程序，包含在操作系统的Socket库中，也就在计算机中

⑤Socket库:  用于调用网络功能的组件集合，解析器是其中之一

⑥解析过程：通过调用解析器，然后解析器会发送请求给DNS服务器，然后服务器会返回相应的IP地址

⑦解析器工作原理：

![img](file:///F:/%E6%9C%89%E9%81%93%E4%BA%91%E7%AC%94%E8%AE%B0/weixinobU7VjnspAWEhOHHCQhci1iqUFZw/84fac2bc2f9344a89c53e27860f3b49b/clipboard.png)

⑧域名：独一无二 不可重复

⑨DNS工作原理：客户端会向DNS服务器发送消息包括：域名、Class、类型（A为IP地址，MX邮件），通过查询表来找到相应的IP地址

![img](file:///F:/%E6%9C%89%E9%81%93%E4%BA%91%E7%AC%94%E8%AE%B0/weixinobU7VjnspAWEhOHHCQhci1iqUFZw/5a44de1284e54aa08cfc3b19ee6dd061/clipboard.png)

⑩寻找相应的DNS服务器： 例www.lab.glasscom.com域名，会被分为com域，glasscom.com域,lab.glasscom.com域，www域，不同的DNS服务器保存不同的域，但是子域（上一级的域会保存下一级的域），而且都会保存根域（全世界根域IP地址只有13个），所以任意的DNS都可以访问根，从根访问下面的子域。

![img](file:///F:/%E6%9C%89%E9%81%93%E4%BA%91%E7%AC%94%E8%AE%B0/weixinobU7VjnspAWEhOHHCQhci1iqUFZw/4b0d2c4d421445bc8733c7e21dab561b/clipboard.png)