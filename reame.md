(0)工具(zk+kfk)已在压缩文件中 解压后无需修改

(1)启动zookeeper
    双击zkServer
(2)将kafka启动kafka
    cd到bin\window下 运行
.\kafka-server-start.bat ..\..\config\server.properties
    
(3)去数据库建库建表 database:kfk table:tb_user  语句在sql/sql.sql里
(4)依次运行 producer的ProducerApplication和consumer的ConsumerApplication
(5).双击测试html打开index页面即可交互 