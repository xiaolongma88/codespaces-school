import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class CreateEmpTable {
    public static void main(String[] args) throws Exception {
        // 创建HBase配置对象
        Configuration conf = HBaseConfiguration.create();

        // 创建HBase连接对象
        Connection conn = ConnectionFactory.createConnection(conf);

        // 创建HBase管理对象
        Admin admin = conn.getAdmin();

        // 创建表描述符对象
        HTableDescriptor tableDesc = new HTableDescriptor(TableName.valueOf("emp"));

        // 创建列族描述符对象
        HColumnDescriptor infoDesc = new HColumnDescriptor("info");

        // 添加列族描述符到表描述符中
        tableDesc.addFamily(infoDesc);

        // 添加列到列族中
        infoDesc.addFamily("empno".getBytes());
        infoDesc.addFamily("ename".getBytes());
        infoDesc.addFamily("job".getBytes());
        infoDesc.addFamily("mgr".getBytes());
        infoDesc.addFamily("hiredate".getBytes());
        infoDesc.addFamily("sal".getBytes());
        infoDesc.addFamily("credit".getBytes());
        infoDesc.addFamily("deptno".getBytes());

        // 创建表
        admin.createTable(tableDesc);

        // 关闭资源
        admin.close();
        conn.close();
    }
}