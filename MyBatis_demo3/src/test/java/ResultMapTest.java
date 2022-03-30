import com.example.mybatis.mapper.EmpMapper;
import com.example.mybatis.pojo.Emp;
import com.example.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author xllinnn
 * @create 2022-03-23 18:49
 */


/**
 * 解决字段名和属性名不一致的情况
 * a为字段起别名，保持和属性名的一致
 * b设置全局配置，将_自动映射为驼峰
 * <setting name="mapUnderscoreToCamelCase" value="true"/>
 * c通过resultMap设置自定义的映射关系
 *     <resultMap id="empResultMap" type="Emp">
 *         <id property="eid" column="eid"></id>
 *         <result property="empName" column="emp_name"></result>
 *         <result property="age" column="age"></result>
 *         <result property="sex" column="sex"></result>
 *         <result property="email" column="email"></result>
 *     </resultMap>
 *
 * 处理多对一的映射关系：
 *a级联属性赋值
 *
 */
public class ResultMapTest {

    @Test
    public void test(){
        System.out.println("第三次");
        System.out.println("第四次");
        System.out.println("master");

    }


    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(1);
        System.out.println(emp);
    }

    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(System.out::println);
    }


}
