(0)工具(zk+kfk)已在tools中 无需修改 
但低版本windows尽量放在浅路径下,不然文件路径太长会启动不了

(1)启动zookeeper 双击bin\zkServer.cmd
(2)启动kafka 在kafka文件夹 用命令行运行以下一行命令
.\bin\windows\kafka-server-start.bat  .\config\server.properties
    
(3)去数据库建库建表 database:kfk table:tb_user  语句在sql/sql.sql里
(4)依次运行 producer的ProducerApplication和consumer的ConsumerApplication

(5).双击front-web/index.html用浏览器打开页面即可交互 